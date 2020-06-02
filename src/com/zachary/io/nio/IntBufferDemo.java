package com.zachary.io.nio;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月1日 下午4:58:12
 */
public class IntBufferDemo {
	private static final int BSIZE = 1024;
	public static void main(String[] args) {
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		IntBuffer inff = buff.asIntBuffer();
		inff.put(new int[] {11, 42, 47, 99, 143, 811, 1016});
		System.out.println(inff.get(3));
		
		inff.put(3, 1881);
		inff.flip();
		while(inff.hasRemaining()) {
			System.out.print(inff.get() + " ");
		}
	}
}
