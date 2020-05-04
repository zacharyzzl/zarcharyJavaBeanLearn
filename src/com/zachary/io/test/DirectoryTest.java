package com.zachary.io.test;

import java.io.File;

import org.junit.Test;

import com.zachary.io.file.util.Directory;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月4日 下午1:18:30
 */
public class DirectoryTest {
	@Test
	public void treeInfoTest() {
		Directory.TreeInfo treeInfo= Directory.TreeInfo.walk("./src");
		for (File item : treeInfo) {
			System.out.println(item);
		}
		System.out.println(treeInfo.dirs);
		System.out.println("=====================");
		System.out.println(treeInfo);
	}
	
	@Test
	public void localTest() {
		File [] files = Directory.local("./src", ".*com");
		for (File item : files) {
			System.out.println(item);
		}
	}
}
