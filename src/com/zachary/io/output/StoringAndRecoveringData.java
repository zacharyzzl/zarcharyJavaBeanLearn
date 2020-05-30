package com.zachary.io.output;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月5日 下午4:25:28
 */
public class StoringAndRecoveringData {
	public static void dataOutputStream() throws IOException {
		String file = "file/output/Data.txt";
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		out.writeDouble(3.14159);
		out.writeUTF("That was pi");
		out.writeDouble(1.41413);
		out.writeUTF("Square root of 2");
		out.close();

		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
		in.close();
	}
	public static void main(String[] args) throws IOException {
		dataOutputStream();
	}
}
