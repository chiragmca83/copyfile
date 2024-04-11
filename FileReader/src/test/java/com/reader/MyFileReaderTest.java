package com.reader;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

public class MyFileReaderTest {
	
	@InjectMocks
    MyFileReader myFileReader;

	@Test
	public void copyFile() throws IOException {
	    MyFileReader mockFileReader = Mockito.mock(MyFileReader.class);
	
	    Mockito.when(mockFileReader.copyFile()).thenReturn("CBA");
	    doNothing().when(mockFileReader).writeFileContent(Mockito.anyString());
		
		String fileContent = "ABC";
		String expected = "CBA";
		
		String inFilePath = "src\\main\\resources\\Input.txt";
		String outFilePath = "src\\main\\resources\\Output.txt";
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(inFilePath));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFilePath));
		
		MyFileReader fileReader = new MyFileReader(bufferedReader, bufferedWriter);
		
		String actual = fileReader.copyFile();
		System.out.println("Actul : "+ fileContent);
		System.out.println("expected : "+ expected);
		
		Assert.assertNotNull(actual);

		assertTrue(actual.equals(expected));
	}
}
