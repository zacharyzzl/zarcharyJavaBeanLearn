package com.zachary.io.serializable;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

class Blip1 implements Externalizable {
	public Blip1(){
		System.out.println("Blip1 Constructor");
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip1.writeExternal");
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip1.readExternal");
	}
}

class Blip2 implements Externalizable {
	Blip2(){
		System.out.println("Blip2 constructor");
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("Blip2.writeExternal");
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("Blip2.readExternal");
	}
}

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月3日 下午1:13:43
 */
public class Blips{
	public static void main(String[] args) throws Exception {
		Blip1 blip1 = new Blip1();
		Blip2 blip2 = new Blip2();
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file/output/serializable/Blips.out"));
		out.writeObject(blip1);
		out.writeObject(blip2);
		out.flush();
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("file/output/serializable/Blips.out"));
		in.readObject();
//		in.readObject(); // 构造函数不是public的会报：java.io.InvalidClassException: com.zachary.io.serializable.Blip2; no valid constructor
		in.close();
	}
}