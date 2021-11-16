package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import UIStore.CorporategiftpageUI;
import UIStore.LandingpageUI;
import Utility.Extentreports;

public class CorporateGifts {
	WebDriver driver;
	Extentreports er;
	
	public CorporateGifts(WebDriver driver, Extentreports er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	
	public void clickoncorporategift(LandingpageUI lploc) {
		er.startTest("Corporate Gift - R001");
		lploc.getcorporategift().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		er.endTest();
	}
	
	public void enterdetails(CorporategiftpageUI cgp)
	{
		cgp.getname().sendKeys("ABCD");
		cgp.getemail().sendKeys("abcd@gmail.com");
		cgp.getphone().sendKeys("1234567892");
		er.startTest("Corporate Gift entering details - R001");
		cgp.getmessage().sendKeys("Message");
		cgp.getsubmit().click();
		er.endTest();
	}
	
	public void verification(CorporategiftpageUI cgp) {
		System.out.println(cgp.getverification().getText());
	}
}
