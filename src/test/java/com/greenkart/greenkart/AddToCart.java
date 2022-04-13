package com.greenkart.greenkart;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.greenkart.pojoclass.GreenKartPageObjectManager;

public class AddToCart extends BaseClassGreenKart {

	public static WebDriver driver = BaseClassGreenKart.getBrowser("chrome");
	public static GreenKartPageObjectManager pom = new GreenKartPageObjectManager(driver);
	
	
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {

		getUrl(FileReadManagerGreenKart.getInstanceFRM().getInstanceCR().getUrl());

		Thread.sleep(2000);
		addItems();
		checkOut();
		country();
		topDeals();
	
	}

	public static void addItems() throws InterruptedException {
		
		String[] veggies = {"Beans","Potato","Brocolli","Cucumber","Carrot","Water Melon"};
		List<WebElement> itemsList = pom.getInstanceHome().getpName();
		List<String> addedVegg = Arrays.asList(veggies);
		//item select logic
		pom.getInstanceHome().itemslogic(itemsList, addedVegg, veggies);
		clickButton(pom.getInstanceHome().getpCart());
	
	}

	public static void checkOut() throws InterruptedException, FileNotFoundException, IOException {
		
		WebDriverWait wt = new WebDriverWait(driver, 5);
		clickButton(pom.getInstanceCheck().getProceedCheckOut());
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoCode")));
		inputText(pom.getInstanceCheck().getPromcode(), FileReadManagerGreenKart.getInstanceFRM().getInstanceCR().getPromo());
		clickButton(pom.getInstanceCheck().getPromobtn());
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".promoInfo")));
		String promoCode = getText(pom.getInstanceCheck().getPromoinfo());
		System.out.println(promoCode);
		clickButton(pom.getInstanceCheck().getPlaceorder());

	}
	
	public static void country() {
		
		dropDown(pom.getInstanceDelv().getCountry(),"3","India");
		clickButton(pom.getInstanceDelv().getChkAgree());
		clickButton(pom.getInstanceDelv().getProceed());
		
		
	}
	
	public static void topDeals() throws InterruptedException {
		
		WebDriverWait wt1 = new WebDriverWait(driver, 5);
		wt1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Top Deals']")));
		clickButton(pom.getInstanceDeals().getTopDealsLink());
		String parentWindow = pom.getInstanceDeals().topDealsPageLogic();
		
		List<Integer> price;
		clickButton(pom.getInstanceDeals().getVegFruitSort());
		
		
		do {
			
			List<WebElement> nameList = pom.getInstanceDeals().getColOne();
			price = nameList.stream().filter(s->s.getText().contains("Rice")).map(s->getPrice(s)).collect(Collectors.toList());
		
			price.forEach(s->System.out.println(s));
			
			if(price.size()<1) {
				clickButton(pom.getInstanceDeals().getPriceSize());
			}
		}while(price.size()<1);
		
		pom.getInstanceDeals().browserClose(parentWindow);
	}
	
	public static int getPrice(WebElement element) {
		
		String text = getText(pom.getInstanceDeals().getPriceValue());
		int value = Integer.parseInt(text);
		return value;
		
	}
}
