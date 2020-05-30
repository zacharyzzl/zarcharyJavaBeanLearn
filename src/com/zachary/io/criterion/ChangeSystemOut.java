package com.zachary.io.criterion;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月5日 下午7:34:08
 */
public class ChangeSystemOut {
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out), true);
		out.println("Hello word!");
		out.close();
	}
}
