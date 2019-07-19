package com.greatlearning.w6a3;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteFile {
	public static void main(String arg[]) throws IOException {
		//writing into a file from 1 to 100
		File file = new File("P:\\Great Learning web dev\\java\\CoreJava\\Week 6 Assignment 3\\numbers.txt");
		PrintWriter fileWriter = new PrintWriter(file);
		file.createNewFile();
		for(int i = 1; i <= 100; i++) fileWriter.println(i);
		fileWriter.close();
	}
}