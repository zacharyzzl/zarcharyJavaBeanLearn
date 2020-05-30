package com.zachary.io.nio;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月30日 下午7:12:41
 */
public class AvailableCharSets {
	public static void main(String[] args) {
		// 查看java.nio.charset.Charset类中的数据编码
		SortedMap<String, Charset> charSets = Charset.availableCharsets();
		Iterator<String> it = charSets.keySet().iterator();
		while(it.hasNext()) {
			String csName = it.next();
			System.out.print(csName);
			Iterator aliases = charSets.get(csName).aliases().iterator();
			if(aliases.hasNext()) {
				System.out.print(": ");
			}
			while(aliases.hasNext()) {
				System.out.print(aliases.next());
				if(aliases.hasNext()) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
	}
}
