package com.zachary.io.standard;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月30日 下午3:56:49
 */
public class Redirecting {
	public static void main(String[] args) throws IOException {
		PrintStream console = System.out;
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/com/zachary/io/standard/Redirecting.java"));
		File file = new File("file/output/standard");
		file.mkdirs();
		PrintStream out = new PrintStream(new BufferedOutputStream(new FileOutputStream("file/output/standard/test.out")));
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = br.readLine()) != null) {
			System.out.println(s);
		}
		out.close();
		System.setOut(console);
	}
}
