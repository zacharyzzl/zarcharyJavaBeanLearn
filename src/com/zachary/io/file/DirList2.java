package com.zachary.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月4日 上午11:37:49
 */
public class DirList2 {
	public static FilenameFilter filter(final String regex) {
		return new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(name).matches();
			}
		};
	}
	
	public static void main(String[] args) {
		File path = new File("./src/com/zachary/io/file");
		String [] list;
		if(args.length == 0) {
			list = path.list();
		} else {
			list = path.list(filter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list) {
			System.out.println(dirItem);
		}
	}
}
/**
 *{Args:"D.*\.java"}
 */