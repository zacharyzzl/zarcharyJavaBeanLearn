package com.zachary.io.serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

abstract class Shape implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int RED = 1;
	public static final int BLUE = 2;
	public static final int GREEN = 3;
	private int xPos;
	private int yPos;
	private int dimension;
	private static Random rand = new Random(47);
	private static int counter = 0;

	public abstract void setColor(int newColor);

	public abstract int getColor();

	public Shape(int xPos, int yPos, int dimension) {
		super();
		this.xPos = xPos;
		this.yPos = yPos;
		this.dimension = dimension;
	}

	@Override
	public String toString() {
		return getClass() + "[color=" + getColor() + ", xPos=" + xPos + ", yPos=" + yPos + ", dimension=" + dimension + "]\n";
	}

	public static Shape randomFactory() {
		int xVal = rand.nextInt(100);
		int yVal = rand.nextInt(100);
		int dim = rand.nextInt(100);
		switch (counter++ % 3) {
			default:
			case 0:
				return new Circle(xVal, yVal, dim);
			case 1:
				return new Square(xVal, yVal, dim);
			case 2:
				return new Line(xVal, yVal, dim);
		}
	}
}

class Circle extends Shape {
	private static final long serialVersionUID = 1L;
	private static int color = RED;
	public Circle(int xPos, int yPos, int dimension) {
		super(xPos, yPos, dimension);
	}

	@Override
	public void setColor(int newColor) {
		color = newColor;
	}

	@Override
	public int getColor() {
		return color;
	}
}

class Square extends Shape {
	private static final long serialVersionUID = 1L;
	private static int color;
	public Square(int xPos, int yPos, int dimension) {
		super(xPos, yPos, dimension);
	}

	@Override
	public void setColor(int newColor) {
		color = newColor;
	}

	@Override
	public int getColor() {
		return color;
	}
}

class Line extends Shape {
	private static final long serialVersionUID = 1L;
	private static int color;
	public Line(int xPos, int yPos, int dimension) {
		super(xPos, yPos, dimension);
	}

	public static void serializableStaticState(ObjectOutputStream stream) throws IOException{
		stream.writeInt(color);
	}
	
	public static void deserialiableStaticState(ObjectInputStream stream) throws IOException {
		color = stream.readInt();
	}
	
	@Override
	public void setColor(int newColor) {
		color = newColor;
	}

	@Override
	public int getColor() {
		return color;
	}
}

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月3日 下午3:23:01
 */
public class StoreCADState {
	public static void main(String[] args) throws Exception {
		List<Class<? extends Shape>> shapeTypes = new ArrayList<Class<? extends Shape>>();
		shapeTypes.add(Circle.class);
		shapeTypes.add(Square.class);
		shapeTypes.add(Line.class);
		
		List<Shape> shapes = new ArrayList<Shape>();
		for(int i=0; i<10; i++) {
			shapes.add(Shape.randomFactory());
		}
		for (Shape shape : shapes) {
			shape.setColor(Shape.GREEN);
		}
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("file/output/serializable/CADState.out"));
		out.writeObject(shapeTypes);
		Line.serializableStaticState(out);
		out.writeObject(shapes);
		out.close();
		System.out.println(shapes);
	}
}
