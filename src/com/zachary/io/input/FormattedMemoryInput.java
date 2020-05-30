package com.zachary.io.input;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月5日 下午2:35:03
 */
public class FormattedMemoryInput {
	public static void main(String[] args) throws IOException {
		// 格式化的内存输入
		DataInputStream in = new DataInputStream(new ByteArrayInputStream(
				BufferedInputFile.readFileReader("src/com/zachary/io/input/FormattedMemoryInput.java").getBytes()));
		while(in.available() != 0) {
			System.out.println((char)in.readByte());
		}
	}
}
