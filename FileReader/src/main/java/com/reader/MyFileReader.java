package com.reader;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileReader {

	private BufferedReader reader;
	
	private BufferedWriter writer;
	
	public MyFileReader(BufferedReader reader, BufferedWriter writer) {
		super();
		this.reader = reader;
		this.writer = writer;
	}

	public String copyFile() throws IOException {
		StringBuilder strBuilder = new StringBuilder();
		int i;
		String outputContent = null;
		
		try {
			while ((i = reader.read()) != -1) {
				strBuilder = strBuilder.insert(0,  String.valueOf((char) i));
			}
			
			outputContent = strBuilder.toString();
			writer.write(outputContent);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			writer.flush();
			writer.close();
		}
		
		return outputContent;
	}

	public static void main(String[] args) throws IOException {
		System.out.println("Start reading file");
		
		String inFilePath = "src\\main\\resources\\Input.txt";
		String outFilePath = "src\\main\\resources\\Output.txt";
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inFilePath));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFilePath));
		
		MyFileReader reader = new MyFileReader(bufferedReader, bufferedWriter);
		
		String fileData = reader.copyFile();
		
		System.out.println("File Data:" + fileData);
	}

	
}
