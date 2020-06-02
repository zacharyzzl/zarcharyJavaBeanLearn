package com.zachary.io.nio.mapped;

import java.io.FileOutputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月1日 下午7:25:58
 */
public class FileLocking {
	public static void main(String[] args) throws Exception {
		FileChannel fc = new FileOutputStream("file/output/MappedByteBuffer/Write.tmp").getChannel();
		FileLock lock = fc.tryLock();
		if(lock != null) {
			System.out.println("Locked file");
			TimeUnit.MILLISECONDS.sleep(100);
			lock.release();
			System.out.println("Released Lock");
		}
		fc.close();
	}
}
