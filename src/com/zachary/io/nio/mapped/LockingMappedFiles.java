package com.zachary.io.nio.mapped;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月1日 下午7:44:01
 */
public class LockingMappedFiles {
	static final int LENGTH = 0x8FFFFFF; // 128M
	static FileChannel fc;

	public static void main(String[] args) throws Exception {
		fc = new RandomAccessFile("file/output/MappedByteBuffer/test.dat", "rw").getChannel();
		MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
		for(int i=0; i<LENGTH; i++) {
			out.put((byte)'x');
		}
		new LockingModify(out, 0, 0 + LENGTH/3);
//		new LockingModify(out, 0, 0 + LENGTH/3); // 不能获得锁报错
		new LockingModify(out, LENGTH/2, LENGTH/2 + LENGTH/4);
	}
	
	private static class LockingModify extends Thread {
		private ByteBuffer buff;
		private int start;
		private int end;

		public LockingModify(ByteBuffer buff, int start, int end) {
			this.buff = buff;
			this.start = start;
			this.end = end;
			buff.limit(end);
			buff.position(start);
			this.buff = buff.slice();
			start();
		}

		public void run() {
			try {
				FileLock fl = fc.tryLock(start, end, false);
				System.out.println("Locked " + start + " to " + end);
				while(buff.position() < buff.limit() -1) {
					buff.put((byte)(buff.get() + 1));
				}
				fl.release();
				System.out.println("Released " + start + " to " + end);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
}
