package com.zachary.io.standard;

import java.io.PrintWriter;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月30日 下午3:53:00
 */
public class ChangeSystemWriter {
	public static void main(String[] args) {
		PrintWriter writer = new PrintWriter(System.out, true);
		writer.println("ChangeSystemWriter");
	}
}
