package com.zachary.io.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.zachary.util.PPrint;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月4日 下午4:00:17
 */
public class MakeDirectories {
	private static void usage() {
		System.err.println("Usage:\n" + 
				"MakeDirectories path1 ...\n" + 
				"Create each path\n" +
				"Usage:\n" + 
				"MakeDirectories -d path1 ...\n" + 
				"Create each path\n" + 
				"Usage:\n" + 
				"MakeDirectories -r path1 path2\n" + 
				"Create each path1 to path2");
		System.exit(0);
	}
	private static void fileData(File f) {
		List<String> list = new ArrayList<String>();
		list.add("Absolute path: " + f.getAbsolutePath());
		list.add("Can red: " + f.canRead());
		list.add("Can write: " + f.canWrite());
		list.add("getName: " + f.getName());
		list.add("getParent: " + f.getParent());
		list.add("getPath: " + f.getPath());
		list.add("length: " + f.length());
		list.add("lastModified: " + f.lastModified());
		PPrint.pprint(list);
		if(f.isFile()) {
			System.out.println("It`s a File");
		}else if(f.isDirectory()) {
			System.out.println("It`s a derictory");
		}
	}
	private static void rnameFile(String[] args) {
		File old = new File(args[0]);
		File rname = new File(args[1]);
		old.renameTo(rname);
		fileData(old);
		fileData(rname);
	}
	private static void deleteFiles(String[] args) {
		File file;
		for(String arg: args) {
			file = new File(arg);
			if(file.exists()) {
				System.out.println(file + " exists");
				System.out.println("deleting ...");
				file.delete();
			}
		}
	}
	private static void createFiles(String[] args) {
		File file;
		for(String arg: args) {
			file = new File(arg);
			if(!file.exists()) {
				System.out.println(file + "Doesn`t exists");
				// 创建以此抽象路径名命名的目录，包括任何必需但不存在的父目录。请注意，如果此操作失败，则可能已成功创建了一些必需的父目录。
				file.mkdirs();
				System.out.println("created");
			}else {
				System.out.println(file + " exists");
			}
		}
	}
	public static void main(String[] args) {
		// 查看file属性
		File file = new File("E:\\Work\\javaBean\\javaBeanLearn\\file\\test.txt");
		fileData(file);
		
		// 修改文件名称
		rnameFile(new String [] {"E:\\Work\\javaBean\\javaBeanLearn\\file\\test.txt",
				"E:\\Work\\javaBean\\javaBeanLearn\\file\\testRname.txt"});
		
		String [] fileNames = {"E:\\Work\\javaBean\\javaBeanLearn\\file\\createTest1",
		"E:\\Work\\javaBean\\javaBeanLearn\\file\\createTest2"};
		// 创建文件夹
		createFiles(fileNames);
		// 删除文件夹
		deleteFiles(fileNames);
	}
}
