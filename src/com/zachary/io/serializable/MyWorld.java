package com.zachary.io.serializable;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class House implements Serializable {
	private static final long serialVersionUID = 1L;
}

class Animal implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private House preferredHouse;
	Animal(String name, House preferredHouse) {
		super();
		this.name = name;
		this.preferredHouse = preferredHouse;
	}
	@Override
	public String toString() {
		return "Animal [name=" + name + "[ " + super.toString() + " ], preferredHouse=" + preferredHouse + "]";
	}
}

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月3日 下午2:39:34
 */
public class MyWorld {
	public static void main(String[] args) throws Exception {
		House house = new House();
		List<Animal> animals = new ArrayList<Animal>();
		animals.add(new Animal("Bosco the dog", house));
		animals.add(new Animal("Ralph the hamster", house));
		animals.add(new Animal("Molly thie cat", house));
		System.out.println("animals: " + animals);
		
		ByteArrayOutputStream buf1 = new ByteArrayOutputStream();
		ObjectOutputStream o1 = new ObjectOutputStream(buf1);
		o1.writeObject(animals);
		o1.writeObject(animals);
		o1.close();
		
		ByteArrayOutputStream buf2 = new ByteArrayOutputStream();
		ObjectOutputStream o2 = new ObjectOutputStream(buf2);
		o2.writeObject(animals);
		o2.close();
		
		ObjectInputStream in1 = new ObjectInputStream(new ByteArrayInputStream(buf1.toByteArray()));
		ObjectInputStream in2 = new ObjectInputStream(new ByteArrayInputStream(buf2.toByteArray()));
		List<Animal> animals1 = (List<Animal>) in1.readObject();
		List<Animal> animals2 = (List<Animal>) in1.readObject();
		List<Animal> animals3 = (List<Animal>) in2.readObject();
		System.out.println("animals1: " + animals1);
		System.out.println("animals2: " + animals2);
		System.out.println("animals3: " + animals3);
		in1.close();
		in2.close();
	}
}
