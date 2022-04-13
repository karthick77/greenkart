package com.greenkart.pojoclass;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopDealsPojo {

	
	 public static WebDriver driver;
	 
	 public TopDealsPojo(WebDriver driver) {
		TopDealsPojo.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 

	 @FindBy(xpath = "//a[text()='Top Deals']")
	 private static WebElement topDealsLink;
	 
	
	 @FindBy(xpath = "//tr//th/span[contains(text(),'name')]")
	 private static WebElement vegFruitSort;
	 

	 @FindBy(xpath = "//tr//td[1]")
	 private static List<WebElement> colOne;
	 
	
	 @FindBy(xpath = "//a[@aria-label='Next']")
	 private static WebElement priceSize;
	 
	
	 public  WebElement getTopDealsLink() {
		return topDealsLink;
	}


	public  WebElement getVegFruitSort() {
		return vegFruitSort;
	}


	public  List<WebElement> getColOne() {
		return colOne;
	}


	public  WebElement getPriceSize() {
		return priceSize;
	}


	public  WebElement getPriceValue() {
		return priceValue;
	}


	@FindBy(xpath = "//tr/td[1][contains(text(),'Rice')]//following-sibling::td[position() = 1]")
	 private static WebElement priceValue;
	
	public  String topDealsPageLogic() throws InterruptedException {
		
		String parent = driver.getWindowHandle();
		System.out.println(parent);
		Set<String> allWindow = driver.getWindowHandles();
		
		for (String win : allWindow) {
			driver.switchTo().window(win);
		}
		
		Thread.sleep(3000);
		return parent;
	}
	
	public void browserClose(String parent) throws InterruptedException {
	
		
		System.out.println(parent);
		Set<String> allWindow = driver.getWindowHandles();
		
		for (String win : allWindow) {
	
			if(!win.equals(parent)) {
				driver.switchTo().window(win);
				driver.close();
			}
			}
			Thread.sleep(2000);
			driver.switchTo().window(parent);
			driver.close();
			
		}
	}
	
	
	


