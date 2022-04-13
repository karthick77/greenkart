package com.greenkart.greenkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CountryToDeliver {

	public static WebDriver driver;
	
	public CountryToDeliver(WebDriver driver) {
		CountryToDeliver.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div[class='wrapperTwo'] select")
	private static WebElement country;
	
	@FindBy(css = "[class='chkAgree']")
	private static WebElement chkAgree;
	
	@FindBy(xpath = "//button[ text()='Proceed']")
	private static WebElement proceed;

	public  WebElement getCountry() {
		return country;
	}
	public  WebElement getChkAgree() {
		return chkAgree;
	}
	public  WebElement getProceed() {
		return proceed;
	}
	
}
