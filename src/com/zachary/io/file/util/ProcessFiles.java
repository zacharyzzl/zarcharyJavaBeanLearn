package com.zachary.io.file.util;

import java.io.File;
import java.io.IOException;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月4日 下午3:20:20
 */
public class ProcessFiles {
	public interface Strategy{
		/**
		 * [文件处理抽象方法]
		 * @param file
		 */
		void process(File file);
	}
	private Strategy strategy;
	private String ext;
	public ProcessFiles(Strategy strategy, String ext) {
		this.strategy = strategy;
		this.ext = ext;
	}
	public void start(String[] args) {
		try {
			if(args.length == 0) {
				processDirectoryTree(new File("."));
			}else {
				for(String arg: args) {
					File fileArg = new File(arg);
					if(fileArg.isDirectory()) {
						processDirectoryTree(fileArg);
					}else {
						if(!arg.endsWith("." + ext)) {
							arg += "." + ext;
						}
						strategy.process(new File(arg).getCanonicalFile());
					}
				}
			}
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
	public void processDirectoryTree(File root) throws IOException {
		// getAbsoluteFile是不会抛出异常的，而getCanonicalFile会抛出IOException.都是放绝对路径
		// getCanonicalPath比getAbsolutePath多了fs.canonicalize操作，而这个FileSystem类是与操作系统相关的
		// getCanonicalPath会将文件路径解析为与操作系统相关的唯一的规范形式的字符串，而getAbsolutePath并不会。
		for(File file: Directory.TreeInfo.walk(root.getAbsolutePath(), ".*\\." + ext)) {
			strategy.process(file.getCanonicalFile());
		}
	}
	public static void main(String[] args) {
		new ProcessFiles(new ProcessFiles.Strategy() {
			@Override
			public void process(File file) { // 文件处理实现
				System.out.println(file);
			}
		}, "java").start(args);
	}
}
