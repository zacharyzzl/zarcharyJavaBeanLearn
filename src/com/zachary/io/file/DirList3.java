package com.zachary.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月4日 上午11:56:50
 * args : "D.*2\.java"
 */
public class DirList3 {
	public static void main(String[] args) {
		File path = new File("./src/com/zachary/io/file");
		String [] list;
		if(args.length == 0) {
			list = path.list();
		} else {
			list = path.list(new FilenameFilter() {
				Pattern pattern = Pattern.compile(args[0]);
				@Override
				public boolean accept(File dir, String name) {
					return pattern.matcher(name).matches();
				}
			});
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list) {
			System.out.println(dirItem);
		}
	}
}
