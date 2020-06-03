package com.zachary.io.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月3日 下午2:21:05
 */
public class SerialCtl implements Serializable {
	private static final long serialVersionUID = 1L;
	private String a;
	private transient String b;
	
	public SerialCtl(String a, String b) {
		super();
		this.a = "No transient" + a;
		this.b = "Transient" + b;
	}
	
	@Override
	public String toString() {
		return "SerialCtl [a=" + a + ", b=" + b + "]";
	}

	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		stream.writeObject(b);
	}
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		b = (String) stream.readObject();
	}
	
	public static void main(String[] args) throws Exception {
		SerialCtl sc = new SerialCtl("Test1", "Test2");
		System.out.println("Before\n" + sc);
		
		ByteArrayOutputStream buf = new ByteArrayOutputStream();
		ObjectOutputStream out = new ObjectOutputStream(buf);
		out.writeObject(sc);
		out.close();
		
		ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(buf.toByteArray()));
		sc = (SerialCtl) in.readObject();
		System.out.println("After\n" + sc);
		in.close();
	}
}
