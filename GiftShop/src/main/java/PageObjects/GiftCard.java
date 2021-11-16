package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import UIStore.GiftcardpageUI;
import UIStore.LandingpageUI;
import Utility.Extentreports;

public class GiftCard {
	WebDriver driver;
	Extentreports er;
	
	public GiftCard(WebDriver driver, Extentreports er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	
	public void clickongiftcard(LandingpageUI lploc) {
		lploc.getgiftcard().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void addtowishlist(GiftcardpageUI gcploc)
	{
		gcploc.addtowishlists().click();
		er.startTest("Adding to WishList - R006");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		er.endTest();
	}
	
	public void checkCOD(GiftcardpageUI gcploc)
	{
		er.startTest("Gift Card & Cash On Delivery - R005");
		gcploc.getpin().sendKeys("560054");
		gcploc.checkpin().click();
		er.endTest();
	}
	
	public void addtocart(GiftcardpageUI gcploc)
	{
		gcploc.getaddtocart().click();
	}
	
	public void getAvailability(GiftcardpageUI gcploc)
	{
		System.out.println(gcploc.getavailability().getText());
	}
	
}
