package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import UIStore.LandingpageUI;
import UIStore.ShopobycategoryUI;
import Utility.Extentreports;

public class Shopbycategory {
	WebDriver driver;
	Extentreports er;
	
	public Shopbycategory(WebDriver driver, Extentreports er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonshopbycategory(LandingpageUI lploc) {
		WebElement sbc = lploc.getshopbycategory();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(sbc).build().perform();
		er.startTest("Shop by category - R002");
		lploc.getfacemaskfromdropdown().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		er.endTest();
	}

	public void sortBy(ShopobycategoryUI scloc) {
		// TODO Auto-generated method stub
		er.startTest("Filter by new - R002");
		scloc.getsortby().click();
		scloc.getsortby().sendKeys(Keys.DOWN);
		scloc.getsortby().sendKeys(Keys.ENTER);
		er.endTest();
	}

	
}
