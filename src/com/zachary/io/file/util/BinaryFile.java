package com.zachary.io.file.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月5日 下午5:58:55
 */
public class BinaryFile {
	public static byte[] read(File bFile) throws IOException{
		BufferedInputStream bf = new BufferedInputStream(new FileInputStream(bFile));
		try {
			byte[] data = new byte[bf.available()];
			bf.read(data);
			return data;
		} finally {
			bf.close();
		}
	}
	public static byte[] read(String bFile) throws IOException {
		return read(new File(bFile).getAbsoluteFile()); // 获取绝对路径
	}
	
	public static void main(String[] args) throws IOException {
		byte[] data = read("src/com/zachary/io/file/util/BinaryFile.java");
		for (byte b : data) {
			System.out.println((char) b);
		}
	}
}
