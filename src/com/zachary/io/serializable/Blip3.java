package com.zachary.io.serializable;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月3日 下午1:35:49
 */
public class Blip3 implements Externalizable{
	private int i;
	private String s; // No initialzation
	public Blip3() {
		System.out.println("Blip3 constructor");
	}
	public Blip3(int i, String s) {
		System.out.println("Blip3(int i, String s) constructor");
		this.i = i;
		this.s = s;
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(i);
		out.writeObject(s);
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		i = in.readInt();
		s = (String) in.readObject();
	}
	
	public String toString() {
		return s + i;
	}
	
	public static void main(String[] args) throws Exception {
		Blip3 b3 = new Blip3(47, "A String ");
		System.out.println(b3);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file/output/serializable/Blip3.out"));
		out.writeObject(b3);
		out.flush();
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("file/output/serializable/Blip3.out"));
		b3 = (Blip3) in.readObject();
		System.out.println(b3);
		in.close();
	}
}
