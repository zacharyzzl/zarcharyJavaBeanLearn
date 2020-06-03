package com.zachary.io.serializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月3日 下午1:59:18
 */
public class Logon implements Serializable {
	private static final long serialVersionUID = 1L;
	private Date date = new Date();
	private String name;
	private transient String password;
	
	public Logon(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Logon [date=" + date + ", name=" + name + ", password=" + password + "]";
	}
	
	public static void main(String[] args) throws Exception {
		Logon a = new Logon("Hulk", "myLittlePony");
		System.out.println("Logon a = " + a);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file/output/serializable/Logon.out"));
		out.writeObject(a);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("file/output/serializable/Logon.out"));
		a = (Logon) in.readObject();
		System.out.println("Logon a = " + a);
		in.close();
	}
}
