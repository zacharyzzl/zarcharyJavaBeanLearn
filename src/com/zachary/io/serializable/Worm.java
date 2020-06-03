package com.zachary.io.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Random;

class Data implements Serializable {
	private static final long serialVersionUID = 1L;
	private int n;
	public Data(int n) {
		this.n = n;
	}

	@Override
	public String toString() {
		return Integer.toString(n);
	}
}

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月3日 上午9:39:52
 */
public class Worm implements Serializable {
	private static final long serialVersionUID = 1L;
	private static Random rand = new Random(47);
	private Data[] d = { new Data(rand.nextInt(10)), new Data(rand.nextInt(10)), new Data(rand.nextInt(10)) };
	private Worm next;
	private char c;
	public Worm(int i, char x) {
		System.out.println("Worn constructor: " + i);
		c = x;
		if(--i>0) {
			next = new Worm(i, (char)(x + 1));
		}
	}
	public Worm() {
		System.out.println("Defult constructor");
	}
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(":");
		result.append(c);
		result.append("(");
		for(Data data: d) {
			result.append(data);
		}
		result.append(")");
		
		if(next != null) {
			result.append(next);
		}
		return result.toString();
	}
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Worm w = new Worm(6, 'a');
		System.out.println("w = " + w);
		File file = new File("file/output/serializable");
		file.mkdirs();
		// 写到文件中
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file/output/serializable/worm.out"));
		out.writeObject("Worm storage\n");
		out.writeObject(w);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("file/output/serializable/worm.out"));
		String s = (String) in.readObject();
		Worm w2 = (Worm) in.readObject();
		System.out.println(s + "w2 = " + w2);
		in.close();
		
		// 写到数组中
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream out2 = new ObjectOutputStream(bout);
		out2.writeObject("Worm storage\n");
		out2.writeObject(w2);
		out2.flush();
		out2.close();
		
		ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
		s = (String) in2.readObject();
		Worm w3 = (Worm) in2.readObject();
		System.out.println(s + "w3 = " + w3);
		in2.close();
		
	}
}
