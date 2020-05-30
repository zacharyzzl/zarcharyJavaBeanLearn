package com.zachary.io.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import com.zachary.util.OSExecuteException;

/**
 * @author Zachary.Zheng
 * @version 1.0
 * @date 2020年5月30日 下午4:15:07
 */
public class OSExecute {
	public static void command(String command) {
		boolean err = false;
		try {
			Process process = new ProcessBuilder(command.split(" "))
					.directory(new File("E:\\Work\\javaBean\\javaBeanLearn\\classes\\com\\zachary\\io\\command"))
					.start();
			BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream(),"gbk"));
			String s;
			while ((s = results.readLine()) != null) {
				System.out.println(s);
			}
			BufferedReader errors = new BufferedReader(new InputStreamReader(process.getErrorStream(),"gbk"));
			while ((s = errors.readLine()) != null) {
				System.out.println(s);
				err = true;
			}
		} catch (Exception e) {
			if(!command.startsWith("CMD/C")) {
				command("CMD/C" + command);
			} else {
				throw new RuntimeException(e);
			}
			e.printStackTrace();
		}
		if(err) {
			throw new OSExecuteException("Errors executing " + command);
		}
	}
}
