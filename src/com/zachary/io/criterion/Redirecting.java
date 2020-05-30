package com.zachary.io.criterion;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月5日 下午7:39:11
 */
public class Redirecting {
	public static void redirectingSystemIn() throws FileNotFoundException {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/com/zachary/io/criterion/Redirecting.java"));
		System.setIn(in);
	}
	
	public static void redirectingSystemOut() throws FileNotFoundException {
		File f = new File("file/criterion");
		f.mkdirs();
		
		PrintStream out = new PrintStream(new FileOutputStream("file/criterion/redirect-test.out"));
		System.setOut(out);
	}
	
	public static void redirectingSystemErr() throws FileNotFoundException {
		File f = new File("file/criterion");
		f.mkdirs();
		
		PrintStream out = new PrintStream(new FileOutputStream("file/criterion/error.out"));
		System.setOut(out);
	}
	
	public static void main(String[] args) throws IOException {
		PrintStream console = System.out;
		
		redirectingSystemIn();
		redirectingSystemOut();
		redirectingSystemErr();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = br.readLine()) != null) {
			console.println(s);
		}
		
		console.close();
		System.in.close();
		System.out.close();
		System.err.close();
	}
}
