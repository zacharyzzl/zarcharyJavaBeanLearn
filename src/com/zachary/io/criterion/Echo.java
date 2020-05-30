package com.zachary.io.criterion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月5日 下午7:29:04
 */
public class Echo {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s = in.readLine()) != null && !s.equals("end")) {
			System.out.println(s);
		}
	}
}
