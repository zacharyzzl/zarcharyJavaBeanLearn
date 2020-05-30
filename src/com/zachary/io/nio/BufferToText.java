package com.zachary.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月30日 下午6:40:55
 */
public class BufferToText {
	private static final int BSIZE = 1024;
	public static void main(String[] args) throws IOException {
		FileChannel fc = new FileOutputStream("file/output/nio/data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes()));
		fc.close();
		
		fc = new FileInputStream("file/output/nio/data2.txt").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(BSIZE);
		fc.read(buffer);
		buffer.flip();
		System.out.println(buffer.asCharBuffer()); // 存入时按字节，取出时按char，导致出现乱码
		// 解决乱码 方案1
		String encoding = System.getProperty("file.encoding"); // 发现默认字符集，产生代表字符集名称的字符串
		System.out.println(Charset.forName(encoding).decode(buffer));
		
		
		// 解决乱码 方案2
		fc = new FileOutputStream("file/output/nio/data2.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text".getBytes("UTF-16BE")));
		fc.close();
		
		fc = new FileInputStream("file/output/nio/data2.txt").getChannel();
		buffer.clear();
		fc.read(buffer);
		buffer.flip();
		System.out.println(buffer.asCharBuffer());
		
		// 解决乱码 方案3
		fc = new FileOutputStream("file/output/nio/data2.txt").getChannel();
		buffer = ByteBuffer.allocate(24); // 可以容纳12个字符
		buffer.asCharBuffer().put("Some text");
		fc.write(buffer); // "Some text"只占9个字符
		fc.close();
		
		fc = new FileInputStream("file/output/nio/data2.txt").getChannel();
		buffer.clear();
		fc.read(buffer);
		buffer.flip();
		System.out.println(buffer.asCharBuffer()); // "Some text"只占9个字符，剩余为零的字节也会由它toString()产生的CharBuffer表示（空格）
	}
}
