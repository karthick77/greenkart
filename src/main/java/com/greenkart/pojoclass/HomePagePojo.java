package com.greenkart.pojoclass;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePojo {

	 public static WebDriver driver;
	 
	 public HomePagePojo(WebDriver driver) {
		HomePagePojo.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 
	 @FindBy(xpath = "//h4[@class='product-name']")
	 private static List<WebElement> pName;

	public  List<WebElement> getpName() {
		return pName;
	}
	
	
	@FindBy(xpath = "//div[@class='product-action']/button")
	 private static List<WebElement> pBtn;

	public  List<WebElement> getpBtn() {
		return pBtn;
	}
	
	//driver.findElement(By.cssSelector("img[alt='Cart']"))

	@FindBy(css = "img[alt='Cart']")
	 private static WebElement pCart;

	public  WebElement getpCart() {
		return pCart;
	}
	
	public void itemslogic(List<WebElement> itemsList, List<String> addedVegg, String[] veggies) throws InterruptedException {
		
		int j=0;
		for(int i=0; i<itemsList.size(); i++) {

			String txtAllProd = itemsList.get(i).getText();
			String[] txtSplit = txtAllProd.split("-");
			String txtTrim = txtSplit[0].trim();

			if(addedVegg.contains(txtTrim)) {
				j++;
				getpBtn().get(i).click();
				Thread.sleep(1000);
				if(j==veggies.length) {
					break;
				}
			}
		}

		Thread.sleep(2000);
		
	}
}
