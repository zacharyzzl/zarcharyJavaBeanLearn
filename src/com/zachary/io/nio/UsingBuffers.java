package com.zachary.io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月1日 下午5:27:45
 */
public class UsingBuffers {
	public static void symmetricScramble(CharBuffer buffer) {
		buffer.mark();
		char c1 = buffer.get();
		char c2 = buffer.get();
		buffer.reset();
		buffer.put(c2).put(c1);
	}
	
	public static void main(String[] args) {
		char [] data = "UsingBuffers".toCharArray();
		ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
		CharBuffer cb = bb.asCharBuffer().put(data);
		
		cb.rewind();
		while(cb.hasRemaining()) {
			System.out.print(cb.get());
		}
		System.out.println();
		
		cb.rewind();
		symmetricScramble(cb);
		cb.rewind();
		while(cb.hasRemaining()) {
			System.out.print(cb.get());
		}
		System.out.println();
		
		cb.rewind();
		symmetricScramble(cb);
		cb.rewind();
		while(cb.hasRemaining()) {
			System.out.print(cb.get());
		}
	}
}
