package com.zachary.io.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年6月1日 下午5:04:16
 */
public class ViewBuffers {
	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.wrap(new byte [] {0, 0, 0, 0, 0, 0, 0, 'a'});
		System.out.print("ByteBuffer: ");
		while(bb.hasRemaining()) {
			System.out.print(bb.get() + " ");
		}
		System.out.println();
		
		bb.rewind();
		CharBuffer cb = bb.asCharBuffer();
		System.out.print("CharBuffer: ");
		while(cb.hasRemaining()) {
			System.out.print(cb.get() + " ");
		}
		System.out.println();
		
		bb.rewind();
		ShortBuffer sb = bb.asShortBuffer();
		System.out.print("ShortBuffer: ");
		while(sb.hasRemaining()) {
			System.out.print(sb.get() + " ");
		}
		System.out.println();
		
		bb.rewind();
		IntBuffer ib = bb.asIntBuffer();
		System.out.print("IntBuffer: ");
		while(ib.hasRemaining()) {
			System.out.print(ib.get() + " ");
		}
		System.out.println();
		
		bb.rewind();
		LongBuffer lb = bb.asLongBuffer();
		System.out.print("LongBuffer: ");
		while(lb.hasRemaining()) {
			System.out.print(lb.get() + " ");
		}
		System.out.println();
		
		bb.rewind();
		FloatBuffer fb = bb.asFloatBuffer();
		System.out.print("FloatBuffer: ");
		while(fb.hasRemaining()) {
			System.out.print(fb.get() + " ");
		}
		System.out.println();
		
		bb.rewind();
		DoubleBuffer db = bb.asDoubleBuffer();
		System.out.print("DoubleBuffer: ");
		while(db.hasRemaining()) {
			System.out.print(db.get() + " ");
		}
	}
}
