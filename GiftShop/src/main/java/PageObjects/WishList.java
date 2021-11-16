package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import UIStore.LandingpageUI;
import Utility.Extentreports;

public class WishList {
	WebDriver driver;
	Extentreports er;
	
	
	public WishList(WebDriver driver, Extentreports er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	public void clickonwishlist(LandingpageUI lploc)
	{
		er.startTest("Wish List - R006");
		lploc.getwishlist().click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		er.endTest();
	}
	
}
