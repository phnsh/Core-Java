package com.greatlearning.w6a3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile {
	public static void main(String[] args) throws IOException {
		Scanner scans = new Scanner(System.in);
		System.out.println("Enter the full file path to read: ");
		String filePath = scans.nextLine();

		try	(FileReader fileReader = new FileReader(filePath);
			BufferedReader bReader = new BufferedReader(fileReader)) {
			String line;
			
			while((line = bReader.readLine()) != null) System.out.println(line);
			
			bReader.close();
			scans.close();
			fileReader.close();
			
		} catch(FileNotFoundException e) {
			System.out.println("File not found in the provided path");
		}
	}
}