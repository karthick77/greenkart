package com.greenkart.pojoclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.greenkart.greenkart.CountryToDeliver;

public class GreenKartPageObjectManager {
	
	public static WebDriver driver;
	
	public GreenKartPageObjectManager(WebDriver driver) {
		GreenKartPageObjectManager.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	

	private static  HomePagePojo home;
	private static CheckOutPojo check;
	private static CountryToDeliver delv;
	private static TopDealsPojo deals;
	
	public  TopDealsPojo getInstanceDeals() {
		deals = new TopDealsPojo(driver);
		return deals;
	}

	public   HomePagePojo getInstanceHome() {
		home = new HomePagePojo(driver);
		return home;
	}

	public  CheckOutPojo getInstanceCheck() {
		check = new CheckOutPojo(driver);
		return check;
	}
	
	public  CountryToDeliver getInstanceDelv() {
		delv = new CountryToDeliver(driver);
		return delv;
	}
}
