package com.zachary.io.output;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月5日 下午4:39:59
 */
public class UsingRandomAccessFile {
	static String FILE = "file/output/rtest.dat";
	public static void display() throws IOException {
		RandomAccessFile rf = new RandomAccessFile(FILE, "r"); // 只读
		for(int i =0; i< 7; i++) {
			System.out.println("Value " + i + ": " + rf.readDouble());
		}
		System.out.println(rf.readUTF());
		rf.close();
	}
	public static void readAndWriteFile() throws IOException {
		RandomAccessFile rf = new RandomAccessFile(FILE, "rw");
		for(int i =0; i< 7; i++) {
			rf.writeDouble(i * 1.414);
		}
		rf.writeUTF("The end of the file");
		rf.close();
		display();
		
		System.out.println("====================================");
		rf = new RandomAccessFile(FILE, "rw");
		// double总是8个字节长，所以seek找到第五个双精度
		rf.seek(5*8);
		rf.writeDouble(47.00001);
		rf.close();
		display();
	}
	public static void main(String[] args) throws IOException {
		readAndWriteFile();
	}
}
