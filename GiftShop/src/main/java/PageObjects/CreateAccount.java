package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import UIStore.LandingpageUI;
import UIStore.LoginpageUI;
import UIStore.SignuppageUI;
import Utility.Extentreports;

public class CreateAccount {
	WebDriver driver;
	Extentreports er;
	
	public CreateAccount(WebDriver driver, Extentreports er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonlogin(LandingpageUI lploc) {
		lploc.getsignup().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void clickoncreateaccount(LoginpageUI lploc) {
		lploc.getcreateaccount().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void enterdetails()
	{
		er.startTest("Creating an account - R003");
		SignuppageUI sploc = new SignuppageUI(driver);
		sploc.getfname().sendKeys("Pooja");
		sploc.getlname().sendKeys("Suresh");
		sploc.getemail().sendKeys("abcd123@gmail.com");
		sploc.createpassword().sendKeys("password1");
		//sploc.getcreateaccount().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		er.endTest();
	}
	
	public void getmessage()
	{
		System.out.println(driver.findElement(By.xpath("//div[@class='errors']")).getText());
	}
}
