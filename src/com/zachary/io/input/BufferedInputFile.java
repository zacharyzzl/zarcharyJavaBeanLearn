package com.zachary.io.input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月5日 下午2:02:07
 */
public class BufferedInputFile {
	/**
	 * BufferedReader 缓冲输入文件测试
	 * InputStream转Reader
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String readFileInputStream(String file) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		StringBuilder sb = new StringBuilder();
		String s;
		while((s = in.readLine()) != null) {
			sb.append(s + "\n");
		}
		in.close();
		return sb.toString();
	}
	/**
	 * BufferedReader 缓冲输入文件测试
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static String readFileReader(String file) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(file));
		StringBuilder sb = new StringBuilder();
		String s;
		while((s = in.readLine()) != null) {
			sb.append(s + "\n");
		}
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		System.out.println(readFileReader("src/com/zachary/io/input/BufferedInputFile.java"));
	}
}
