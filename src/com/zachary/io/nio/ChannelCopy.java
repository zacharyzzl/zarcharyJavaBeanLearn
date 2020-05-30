package com.zachary.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月30日 下午5:20:28
 */
public class ChannelCopy {
	private static final int BSIZE = 1024;
	public static void main(String[] args) throws IOException {
		FileChannel in = new FileInputStream("file/output/nio/copySource.txt").getChannel();
		FileChannel out = new FileOutputStream("file/output/nio/copyDest.txt").getChannel();
		ByteBuffer buff = ByteBuffer.allocate(BSIZE);
		while (in.read(buff) != -1) {
			buff.flip();
			out.write(buff);
			buff.clear();
		}
	}
}
