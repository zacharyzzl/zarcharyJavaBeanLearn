package com.zachary.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月4日 上午11:12:59
 */
public class DirList {
	public static void main(String[] args) {
		File path = new File("src/com/zachary/io/file");
		String [] list;
		if(args.length == 0) {
			list = path.list();
		}else {
			list = path.list(new DirFilter(args[0]));
		}
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list) {
			System.out.println(dirItem);
		}
	}
}

/**
 * [使用正则过滤文件名]
 * @author Zachary.Zheng
 */
class DirFilter implements FilenameFilter{
	private Pattern pattern;
	public DirFilter(String regex) {
		this.pattern = Pattern.compile(regex);
	}
	@Override
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches();
	}
}