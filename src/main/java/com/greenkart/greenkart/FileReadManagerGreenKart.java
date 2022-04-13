package com.greenkart.greenkart;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadManagerGreenKart {
	
	//private constructor
	private FileReadManagerGreenKart() {
		
	}
	//static method
	public static FileReadManagerGreenKart getInstanceFRM() {
		FileReadManagerGreenKart helper = new FileReadManagerGreenKart();
		return helper;
	}
	//non static method
	public ConfigurationReaderGreenKart getInstanceCR() throws FileNotFoundException, IOException {
		ConfigurationReaderGreenKart reader = new ConfigurationReaderGreenKart();
		return reader;
	}

}
