package com.zachary.io.file.util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import com.zachary.util.PPrint;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月4日 下午12:01:34
 */
public final class Directory {
	 // 根据文件名称过滤文件
	public static File[] local(File file, String regex) {
		return file.listFiles(new FilenameFilter(){
			Pattern pattern = Pattern.compile(regex);
			@Override
			public boolean accept(File dir, String name) {
				return pattern.matcher(new File(name).getName()).matches();
			}
		});
	}
	public static File[] local(String path, final String regex) {
		return local(new File(path), regex);
	}
	
	public static class TreeInfo implements Iterable<File> {
		public List<File> files = new ArrayList<File>();
		public List<File> dirs = new ArrayList<File>();
		@Override
		public Iterator<File> iterator() {
			return files.iterator();
		}
		void addAll(TreeInfo other) {
			this.files.addAll(other.files);
			this.dirs.addAll(other.dirs);
		}
		@Override
		public String toString() {
			return "TreeInfo files=" + PPrint.pformat(files) + "\n\ndirs=" + PPrint.pformat(dirs);
		}
		
		public static TreeInfo walk(String start, String regex) {
			return recurseDirs(new File(start), regex);
		}
		public static TreeInfo walk(File start, String regex) {
			return recurseDirs(start, regex);
		}
		public static TreeInfo walk(File start) {
			return recurseDirs(start, ".*");
		}
		public static TreeInfo walk(String start) {
			return recurseDirs(new File(start), ".*");
		}
		static TreeInfo recurseDirs(File startDirs, String regex) {
			TreeInfo result = new TreeInfo();
			for (File item : startDirs.listFiles()) {
				if(item.isDirectory()) {
					result.dirs.add(item);
					result.addAll(recurseDirs(item, regex));
				}else {
					if(item.getName().matches(regex)) {
						result.files.add(item);
					}
				}
			}
			return result;
		}
		public static void main(String[] args) {
			if(args.length == 0) {
				System.out.println(walk("./src"));
			}else {
				System.out.println(walk("./src", args[0]));
			}
		}
	}
}
