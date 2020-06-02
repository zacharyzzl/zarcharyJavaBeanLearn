package com.zachary.io.nio;

import java.nio.ByteBuffer;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月30日 下午7:30:23
 */
public class GetData {
	private static final int BSIZE = 1024;
	public static void main(String[] args) {
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		int i = 0;
		while(i++ < buff.limit()) {
			if(buff.get() != 0) {
				System.out.println("nonzero");
			}
		}
		
		buff.rewind();
		buff.asCharBuffer().put("Howdy");
		char c;
		while((c = buff.getChar()) != 0) {
			System.out.print(c + " ");
		}
		System.out.println();
		
		buff.rewind();
		buff.asShortBuffer().put((short)471142);
		System.out.println(buff.getShort());
		
		buff.rewind();
		buff.asIntBuffer().put(99471142);
		System.out.println(buff.getInt());
		
		buff.rewind();
		buff.asLongBuffer().put(99471142);
		System.out.println(buff.getLong());
		
		buff.rewind();
		buff.asFloatBuffer().put(99471142);
		System.out.println(buff.getFloat());
		
		buff.rewind();
		buff.asDoubleBuffer().put(99471142);
		System.out.println(buff.getDouble());
	}
}
