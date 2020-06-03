package com.zachary.io.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Enumeration;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月2日 下午3:06:37
 */
public class ZIPCompress {
	private static final String FILE = "file/zip/test.zip";
	public static void main(String[] args) throws IOException {
		FileOutputStream f = new FileOutputStream(FILE);
		CheckedOutputStream csum = new CheckedOutputStream(f, new Adler32());
		ZipOutputStream zos = new ZipOutputStream(csum);
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(zos)));
		zos.setComment("A test of Java Zipping");
		
		System.out.println("Writing file GZIPcompress.java");
		
		// 添加GZIPcompress.java文件
		BufferedReader in = new BufferedReader(new FileReader("src/com/zachary/io/zip/GZIPcompress.java"));
		zos.putNextEntry(new ZipEntry("GZIPcompress.java"));
		int c;
		while((c = in.read()) != -1) {
			out.write(c);
		}
		in.close();
		out.flush();
		
		// 添加ZIPCompress.java文件
		in = new BufferedReader(new FileReader("src/com/zachary/io/zip/ZIPCompress.java"));
		zos.putNextEntry(new ZipEntry("ZIPCompress.java"));
		while((c = in.read()) != -1) {
			out.write(c);
		}
		in.close();
		out.flush();
		
		// 压缩两个文件
		out.close();
		// 关闭流对象后查看checksum
		System.out.println("Checksum: " + csum.getChecksum().getValue());
		
		System.out.println("Reading file");
		FileInputStream fi = new FileInputStream(FILE);
		CheckedInputStream csumi = new CheckedInputStream(fi, new Adler32());
		ZipInputStream in2 = new ZipInputStream(csumi);
		BufferedInputStream bis = new BufferedInputStream(in2);
		ZipEntry ze;
		while((ze = in2.getNextEntry()) != null) {
			System.out.print("Reading file " + ze);
			int x;
			while((x = bis.read()) != -1) {
				System.out.write(x);
			}
		}
		System.out.println("Checksum: " + csumi.getChecksum().getValue());
		bis.close();
		
		// 使用ZipFile对象
		ZipFile zf = new ZipFile(FILE);
		Enumeration e = zf.entries();
		while (e.hasMoreElements()) {
			ZipEntry ze2 = (ZipEntry) e.nextElement();
			System.out.println("File: " + ze2);
			
			BufferedInputStream is = new BufferedInputStream(zf.getInputStream(ze2));
			int x;
			while((x = is.read()) != -1) {
				System.out.write(x);
			}
			is.close();
		}
		zf.close();
	}
}
