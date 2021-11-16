package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import UIStore.LandingpageUI;
import UIStore.PersonalizedpageUI;
import Utility.Extentreports;

public class PersonalizedGift {
	WebDriver driver;
	Extentreports er;
	
	public PersonalizedGift(WebDriver driver, Extentreports er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonpersonalizedgift(LandingpageUI lploc) {
		lploc.getpersonalized().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void addproduct(PersonalizedpageUI pploc) {
		er.startTest("Personalized Gift - R001");
		pploc.getpersonalizedproduct().click();
		pploc.getname().sendKeys("Harry");
		pploc.getaddtocart().click();
		er.endTest();
	}
	public void verify(PersonalizedpageUI pploc) {
		System.out.println("To Verify: "+pploc.getverification().getText());
	}
}
