package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import UIStore.LandingpageUI;
import Utility.Extentreports;

public class Newsletter {
	WebDriver driver;
	Extentreports er;

	public Newsletter(WebDriver driver, Extentreports er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}

	public void subscribetonewsletter(LandingpageUI lploc) {
		lploc.getemailfornewsletter().sendKeys("pooja.adi2309@gmail.com");
		er.startTest("Subscribed to Newsletter - R007");
		lploc.getemailfornewsletter().sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		er.endTest();
	}

}
