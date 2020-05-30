package com.zachary.io.file.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月5日 下午4:57:44
 */
public class TextFile extends ArrayList<String> {
	private static final long serialVersionUID = 1L;

	public static String read(String fileName) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(new FileReader(new File(fileName).getAbsoluteFile()));
			try {
				String s;
				while ((s = in.readLine()) != null) {
					sb.append(s);
					sb.append("\n");
				}
			} finally {
				in.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static void write(String fileName, String text) {
		try {
			// PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				out.print(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void write(String fileName) {
		try {
			PrintWriter out = new PrintWriter(new File(fileName).getAbsoluteFile());
			try {
				for (String item : this) {
					out.println(item);
				}
			} finally {
				out.close();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public TextFile(String fileName, String splitter) {
		super(Arrays.asList(read(fileName).split(splitter)));
		// Regular expression split() often leaves an empty.
		// String at the first position.
		if(get(0).equals("")) {
			remove(0);
		}
	}
	
	public TextFile(String fileName) {
		this(fileName, "\n");
	}
	
	public static void main(String[] args) {
		// 调用静态方法写入
		String fileContent = read("src/com/zachary/io/file/util/TextFile.java");
		write("file/output/test.txt", fileContent);
		
		// 创建对象写入
		TextFile text = new TextFile("file/output/test.txt");
		text.write("file/output/test2.txt");
		
		TreeSet<String> words = new TreeSet<String>(new TextFile("src/com/zachary/io/file/util/TextFile.java", "\\w+"));
		/*
		 * headSet(E toElement) 
		 * 返回此集合的部分的视图，其元素严格小于toElement 。 
		 * 返回的集合由此集合支持，因此返回集合中的更改将反映在此集合中，反之亦然。 
		 * 返回的集合支持该集支持的所有可选集合操作。
		 */
		System.out.println(words.headSet("a"));
		
	}
}
