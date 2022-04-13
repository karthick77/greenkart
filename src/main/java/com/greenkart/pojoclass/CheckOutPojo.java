package com.greenkart.pojoclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPojo {
	
	public static WebDriver driver;
	
	public CheckOutPojo(WebDriver driver) {
		CheckOutPojo.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'PROCEED TO CHECKOUT')]")
	private static WebElement proceedCheckOut;

	public  WebElement getProceedCheckOut() {
		return proceedCheckOut;
	}
	
	@FindBy(css = ".promoCode")
	private static WebElement promcode;

	public  WebElement getPromcode() {
		return promcode;
	}
	
	@FindBy(css = ".promoBtn")
	private static WebElement promobtn;
	
	public  WebElement getPromobtn() {
		return promobtn;
	}

	@FindBy(css = ".promoInfo")
	private static WebElement promoinfo;
	
	public  WebElement getPromoinfo() {
		return promoinfo;
	}

	//driver.findElement(By.cssSelector(".promoBtn"))
	//driver.findElement(By.xpath("//button[text()='Place Order']"))
	@FindBy(xpath ="//button[text()='Place Order']")
	private static WebElement placeorder;

	public  WebElement getPlaceorder() {
		return placeorder;
	} 
	
	
}
