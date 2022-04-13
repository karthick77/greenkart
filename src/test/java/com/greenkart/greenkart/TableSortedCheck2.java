package com.greenkart.greenkart;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableSortedCheck2 {

	public static void main(String[] args) {
		
		String path = "\\Driver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+path);
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		getTableElements(driver);

	}
	
	public static void getTableElements(WebDriver driver) {
		
		List<Integer> price;
		driver.findElement(By.xpath("//tr//th/span[contains(text(),'name')]")).click();
		
		do {
			List<WebElement> nameList = driver.findElements(By.xpath("//tr//td[1]"));
			price = nameList.stream().filter(s->s.getText().contains("Rice")).map(s->getPrice(s)).collect(Collectors.toList());
			
			price.forEach(s->System.out.println(s));
			
			if(price.size()<1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		}while(price.size()<1);
		
	}
	
	public static int getPrice(WebElement element) {
		String text = element.findElement(By.xpath("following-sibling::td[position() = 1]")).getText();
		int value = Integer.parseInt(text);
		return value;
		
	}

}
