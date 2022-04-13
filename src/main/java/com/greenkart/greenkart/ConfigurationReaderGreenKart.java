package com.greenkart.greenkart;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReaderGreenKart{

	public Properties props;
	public ConfigurationReaderGreenKart() throws FileNotFoundException, IOException {
		
		File f = new File("C:\\Users\\ELCOT\\eclipse-workspace\\greenkart\\config.properties");
		FileInputStream fis = new FileInputStream(f);
		props = new Properties();
		props.load(fis);
	
	}
	
	public String getUrl() {
		String url = props.getProperty("APP_URL");
		return url;
	}
	
	public String getPromo() {
		String promo = props.getProperty("PROMO_CODE");
		return promo;
		
	}
	

}
