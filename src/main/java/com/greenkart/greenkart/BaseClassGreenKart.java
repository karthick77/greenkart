package com.greenkart.greenkart;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class BaseClassGreenKart {

	public static  WebDriver driver;//Null driver

	public static WebDriver getBrowser(String browser) {

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", 
					System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;	

		case "edge":
			System.setProperty("webdriver.edge.driver", 
					System.getProperty("user.dir")+"\\Driver\\msedgedriver.exe");
			driver = new FirefoxDriver();
			break;		

		default:
			System.setProperty("webdriver.chrome.driver", 
					System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		return driver;
	}

	public static void getUrl(String url) {
		driver.get(url);
	}

	public static void setImpWait(int del, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(del, unit);
	}

	public static void clickButton(WebElement element) {
		element.click();
	}
	public static void inputText(WebElement element, String value) {
		element.sendKeys(value);
	}
	public static void getQuit() {
		driver.quit();
	}

	public static void getClear(WebElement element) {
		element.clear();
	}

	public static String getText(WebElement element) {
		String myTxt = element.getText();
		return myTxt;
	}

	public static void dropDown(WebElement drop, String op, String data) {
		Select sel = new Select(drop);
		switch (op) {
		case "1":
			int num = Integer.parseInt(data);
			sel.selectByIndex(num);
			break;

		case "2":
			sel.selectByValue(data);
			break;	

		case "3":
			sel.selectByVisibleText(data);
			break;	

		default:
			System.out.println("Kindly enter valid options");
			break;
		}
	}

	public static void takeScreenShots(WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String myDate = new SimpleDateFormat("_yyyyMMdd_hhmmss").format(new Date());
		String fileFormat = "Hotel"+myDate+".png";
		File des = new File("C:\\Users\\ELCOT\\eclipse-workspace\\greenkart\\ScreenShots\\"+fileFormat);
		FileUtils.copyFile(src, des);
	}
}
