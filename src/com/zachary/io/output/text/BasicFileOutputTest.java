package com.zachary.io.output.text;

import java.io.IOException;

import org.junit.Test;

import com.zachary.io.output.BasicFileOutput;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月5日 下午2:46:53
 */
public class BasicFileOutputTest {
	@Test
	public void writeByFileWriteTest() {
		try {
			BasicFileOutput.writeByFileWrite();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void writeByOutputStreamTest() {
		try {
			BasicFileOutput.writeByOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
