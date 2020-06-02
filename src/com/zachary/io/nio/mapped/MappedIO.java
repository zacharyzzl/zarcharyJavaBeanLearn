package com.zachary.io.nio.mapped;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月1日 下午6:06:36
 */
public class MappedIO {
	private static int numOfInts = 4000000;
	private static int numUbuffInts = 200000;

	private abstract static class Tester {
		private String name;

		public Tester(String name) {
			this.name = name;
		}

		public void runTest() {
			System.out.println(name + ": ");
			try {
				long start = System.nanoTime();
				test();
				double duration = System.nanoTime() - start;
				System.out.format("%.2f\n", duration/1.0e9);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

		public abstract void test() throws IOException;
	}

	public static Tester[] tests = { 
		new Tester("Stream Write") {
			@Override
			public void test() throws IOException {
				DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("file/output/MappedByteBuffer/Write.tmp")));
				for (int i = 0; i < numOfInts; i++) {
					out.writeInt(i);
				}
				out.close();
			}
		},
		new Tester("Mappend Write") {
			@Override
			public void test() throws IOException {
				FileChannel fc = new RandomAccessFile("file/output/MappedByteBuffer/Write.tmp","rw").getChannel();
				IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
				for (int i = 0; i < numOfInts; i++) {
					ib.put(i);
				}
				fc.close();
			}
		},
		new Tester("Stream Read") {
			@Override
			public void test() throws IOException {
				DataInputStream out = new DataInputStream(new BufferedInputStream(new FileInputStream("file/output/MappedByteBuffer/Write.tmp")));
				for (int i = 0; i < numOfInts; i++) {
					out.readInt();
				}
				out.close();
			}
		},
		new Tester("Mappend Read") {
			@Override
			public void test() throws IOException {
				FileChannel fc = new RandomAccessFile("file/output/MappedByteBuffer/Write.tmp","rw").getChannel();
				IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
				while(ib.hasRemaining()) {
					ib.get();
				}
				fc.close();
			}
		},
		new Tester("Stream Read/Write") {
			@Override
			public void test() throws IOException {
				RandomAccessFile raf = new RandomAccessFile("file/output/MappedByteBuffer/Write.tmp", "rw");
				raf.writeInt(1);
				for(int i = 0; i < numUbuffInts; i++) {
					raf.seek(raf.length() - 4);
					raf.writeInt(raf.read());
				}
				raf.close();
			}
		},
		new Tester("Mappend Read/Write") {
			@Override
			public void test() throws IOException {
				FileChannel fc = new RandomAccessFile("file/output/MappedByteBuffer/Write.tmp","rw").getChannel();
				IntBuffer ib = fc.map(FileChannel.MapMode.READ_WRITE, 0, fc.size()).asIntBuffer();
				ib.put(0);
				for(int i = 1; i < numUbuffInts; i++) {
					ib.put(ib.get(i-1));
				}
				fc.close();
			}
		}
	};
	public static void main(String[] args) {
		for (Tester tester : tests) {
			tester.runTest();
		}
	}
}
