package com.zachary.io.output;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.LineNumberInputStream;
import java.io.PrintWriter;
import java.io.StringBufferInputStream;
import java.io.StringReader;

import com.zachary.io.input.BufferedInputFile;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月5日 下午3:48:25
 */
@SuppressWarnings("deprecation")
public class FileOutputShortcut {
	public static void fileOutputShortcut() throws IOException {
		BufferedReader in = new BufferedReader(new StringReader(
				BufferedInputFile.readFileReader("src/com/zachary/io/output/FileOutputShortcut.java")));
		PrintWriter out = new PrintWriter("file/output/FileOutputShortcut.out");
		String s;
		int lineCount = 1;
		while ((s = in.readLine()) != null) {
			out.println(lineCount + ": " + s);
			lineCount++;
		}
		out.close();
		in.close();
	}

	@Deprecated
	public static void fileOutputShortcut2() throws IOException {
		LineNumberInputStream in = new LineNumberInputStream(new StringBufferInputStream(
				BufferedInputFile.readFileReader("src/com/zachary/io/output/FileOutputShortcut.java")));
		int i;
		int lineCount = 0;
		boolean first = true;
		while ((i = in.read()) != -1) {
			if (lineCount == in.getLineNumber() && first) {
				lineCount++;
				System.out.print(lineCount + ": " + (char) i);
				first = false;
			} else {
				System.out.print((char) i);
				first = true;
			}
		}
		in.close();
	}

	public static void main(String[] args) throws IOException {
		fileOutputShortcut();
	}
}
