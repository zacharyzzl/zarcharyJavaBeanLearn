package com.zachary.io.zip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月2日 下午2:29:32
 */
public class GZIPcompress {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("src/com/zachary/io/zip/GZIPcompress.java"));
		File file = new File("file/zip");
		file.mkdirs();
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream("file/zip/test.gz"))));
		System.out.println("Writing file");
		int c;
		while((c = in.read()) != -1) {
			out.write(c);
		}
		out.close();
		in.close();
		
		System.out.println("Readeing file");
		BufferedReader in2 = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("file/zip/test.gz"))));
		String s;
		while((s = in2.readLine()) != null) {
			System.out.println(s);
		}
		in2.close();
	}
}