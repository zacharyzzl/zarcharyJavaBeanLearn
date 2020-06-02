package com.zachary.io.nio;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月1日 下午5:18:56
 */
public class Endians {
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.wrap(new byte [12]);
		bb.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(bb.array()));
		
		bb.rewind();
		bb.order(ByteOrder.BIG_ENDIAN);
		bb.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(bb.array()));
		
		bb.rewind();
		bb.order(ByteOrder.LITTLE_ENDIAN);
		bb.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(bb.array()));
		while(bb.hasRemaining()) {
			System.out.print(bb.get() + ",");
		}
	}
}
