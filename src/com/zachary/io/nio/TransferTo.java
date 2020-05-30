package com.zachary.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月30日 下午5:33:05
 */
public class TransferTo {
	public static void main(String[] args) throws IOException {
		FileChannel in = new FileInputStream("file/output/nio/copySource.txt").getChannel();
		FileChannel out = new FileOutputStream("file/output/nio/copyDirectDest.txt").getChannel();
		in.transferTo(0, in.size(), out);
		/**
		 * OR:
		 * Out.transferFrom(in, 0, in.size());
		 */
	}
}
