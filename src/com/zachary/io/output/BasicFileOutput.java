package com.zachary.io.output;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;

import com.zachary.io.input.BufferedInputFile;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月5日 下午2:41:50
 */
public class BasicFileOutput {
	public static void writeByFileWrite() throws IOException {
		String file = "file/output/BasicFileOutput_writeByFileWrite.out";
		BufferedReader in = new BufferedReader(
				new StringReader(BufferedInputFile.readFileReader("src/com/zachary/io/output/BasicFileOutput.java")));
		
		File f = new File("file/output");
		f.mkdirs(); // 创建文件夹
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
		String s;
		while((s = in.readLine()) != null) {
			out.write(s + "\n");
		}
		out.close();
		in.close();
		System.out.println(BufferedInputFile.readFileInputStream("file/output/BasicFileOutput_writeByFileWrite.out"));
	}
	
	public static void writeByOutputStream() throws IOException {
		String file = "file/output/BasicFileOutput_writeByOutputStream.out";
		BufferedReader in = new BufferedReader(
				new StringReader(BufferedInputFile.readFileInputStream("src/com/zachary/io/output/BasicFileOutput.java")));
		
		File f = new File("file/output");
		f.mkdirs(); // 创建文件夹
		
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file))));
		String s;
		while((s = in.readLine()) != null) {
			out.write(s + "\n");
		}
		out.close();
		in.close();
		System.out.println(BufferedInputFile.readFileInputStream("file/output/BasicFileOutput_writeByOutputStream.out"));
	}
}
