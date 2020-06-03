package com.zachary.io.serializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月3日 下午3:58:08
 */
public class RecoverCADState {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("file/output/serializable/CADState.out"));
		List<Class<? extends Shape>> shapeTypes = (List<Class<? extends Shape>>) in.readObject();
		System.out.println(shapeTypes);
		Line.deserialiableStaticState(in);
		List<Shape> shapes = (List<Shape>) in.readObject();
		System.out.println(shapes);
	}
}
