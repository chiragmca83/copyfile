package com.reader;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Test;

public class FileReaderTest {

	@Test
	public void copyFile() throws IOException {
		String fileContent = "ABC";
		String expected = "CBA";
		
		Reader reader = new StringReader(fileContent);
		Writer writer = new StringWriter();
		
		BufferedReader bufferedReader = new BufferedReader(reader);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		
		MyFileReader fileReader = new MyFileReader(bufferedReader, bufferedWriter);
		
		String actual = fileReader.copyFile();
		System.out.println("Actul : "+ fileContent);
		System.out.println("expected : "+ expected);

		assertTrue(actual.equals(expected));
	}
}
