package com.zachary.io.nio.mapped;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月1日 下午5:36:11
 */
public class LargeMappedFiles {
	static int length = 0x8FFFFFF; // 128M
	public static void main(String[] args) throws FileNotFoundException, IOException {
		MappedByteBuffer out = new RandomAccessFile("file/output/MappedByteBuffer/data.txt", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
		for(int i=0; i<length; i++) {
			out.put((byte) 'x');
		}
		System.out.println("Finished writing");
		for(int i= length/2; i< length/2 + 6; i++) {
			System.out.println((char)out.get(i));
		}
		
		System.out.println("MappedFileTest writing");
		mappedFileTest();
	}
	
	private static void mappedFileTest() throws FileNotFoundException, IOException {
		MappedByteBuffer out = new RandomAccessFile("file/output/MappedByteBuffer/data.txt", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, 10);
		int count = 0;
		while(out.hasRemaining()) {
			System.out.println((char) out.get());
			count++;
		}
		System.out.println(count);
	}
}
