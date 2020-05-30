package com.zachary.io.input;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月5日 下午2:20:51
 */
public class MemoryIput {
	public static void stringReader() throws IOException {
		StringReader in = new StringReader("地方大锅饭归属感方式");
		int c;
		while((c = in.read()) != -1) {
			System.out.println((char)c);
		}
		in.close();
	}
	public static void main(String[] args) throws IOException {
		// 从内存中输入
		StringReader in = new StringReader(BufferedInputFile.readFileReader("src/com/zachary/io/input/MemoryIput.java"));
		int c;
		while((c = in.read()) != -1) {
			System.out.println((char)c);
		}
		in.close();
		
		// 直接讲字符串用来创建一个StringReader对象
		stringReader();
	}
}
