package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import UIStore.LandingpageUI;
import UIStore.LoginpageUI;
import Utility.Extentreports;

public class Login {
	WebDriver driver;
	Extentreports er;
	
	public Login(WebDriver driver, Extentreports er) {
		this.driver = driver;
		this.er = er;
		PageFactory.initElements(driver, this);
	}
	
	public void clickonlogin(LandingpageUI lploc) {
		lploc.getsignup().click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
		
	public void entercorrectdetails(LoginpageUI lploc)
	{
		er.startTest("Login - R004");
		lploc.getloginemail().sendKeys("s.pooja2309@gmail.com");
		lploc.getloginpassword().sendKeys("password1");
		//lploc.getloginsubmit().click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		er.endTest();
	}
	
	public void forgotpassword(LoginpageUI lploc)
	{
		lploc.getforgotpassword().click();
	}
	
	public void requestpassword(LoginpageUI lploc) throws InterruptedException
	{
		er.startTest("Password Reset - R004");
		lploc.typerecorveryemail().sendKeys("pooja.adi2309@gmail.com");
		lploc.getforgotpasswordsubmitbtn().click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.xpath("//div[@class='errors']")).getText());
		er.endTest();
	}
	
	public void getmessage()
	{
		System.out.println(driver.findElement(By.xpath("//div[@class='errors']")).getText());
	}
}
