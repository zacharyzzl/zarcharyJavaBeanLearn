package com.zachary.io.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月3日 上午10:53:49
 */
public class ThawWrom {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("E:/Work/javaBean/javaBeanLearn/file/output/serializable/worm.out"));
        String s = (String) in.readObject();
        Object w2 = in.readObject();
        System.out.println(s + "w2 = " + w2);
        in.close();
	}
}
