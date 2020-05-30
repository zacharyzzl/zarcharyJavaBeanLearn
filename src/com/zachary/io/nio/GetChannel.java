package com.zachary.io.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月30日 下午5:01:34
 */
public class GetChannel {
	private static final int BSIZE = 1024;
	public static void main(String[] args) throws IOException {
		File file = new File("file/output/nio");
		file.mkdirs();
		FileChannel fc = new FileOutputStream("file/output/nio/data.txt").getChannel();
		fc.write(ByteBuffer.wrap("Some text ".getBytes()));
		fc.close();
		fc = new RandomAccessFile("file/output/nio/data.txt", "rw").getChannel();
		fc.position(fc.size()); // 移动到最后
		fc.write(ByteBuffer.wrap("Some more ".getBytes()));
		fc.close();
		fc = new FileInputStream("file/output/nio/data.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE); // 设置缓冲器大小
		fc.read(buff); // 告知FileChannel向ByteBuffer存储字节
		buff.flip(); // 让缓冲器做好让别人读取字节的准备
		while (buff.hasRemaining()) {
			System.out.print((char) buff.get());
		}
	}
}
