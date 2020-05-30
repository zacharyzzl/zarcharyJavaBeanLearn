package com.zachary.io.standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月30日 下午3:41:47
 */
public class Echo {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s;
		System.out.println("---------------");
		while ((s = reader.readLine()) != null && s.length() != 0) {
			System.out.println("BufferedReader: " + s);
		}
	}
}
