package com.example.demo.service;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EncodingServiceTests {

	@Test
	public void TEST1() throws IOException {
		final String path = "data/new/20180509/";
		final String ext = ".txt";
		File directory = new File(path);

		if(directory.isDirectory()) {
			File[] files = directory.listFiles();
			for(int i = 0; i < files.length; i++) {
				String data = FileUtils.readFileToString(files[i], "CP949");
				FileUtils.write(new File(path+i+ext), data, "UTF-8");
			}
		}

		System.out.println();
	}

	@Test
	public void TEST2() throws IOException {
		final String path = "data/old/20150827/";
		final String ext = ".txt";
		File directory = new File(path);

		if(directory.isDirectory()) {
			File[] files = directory.listFiles();
			for(int i = 0; i < files.length; i++) {
				String data = FileUtils.readFileToString(files[i], "CP949");
				FileUtils.write(new File(path+i+ext), data, "UTF-8");
			}
		}

		System.out.println();
	}

}
