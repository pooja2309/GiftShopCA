package UIStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignuppageUI {
	public WebDriver driver;

	public SignuppageUI(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="FirstName")
	WebElement fname;
	
	public WebElement getfname() {
		return fname;
	}
	
	@FindBy(id="LastName")
	WebElement lname;
	
	public WebElement getlname() {
		return lname;
	}
	
	@FindBy(id="Email")
	WebElement email;
	
	public WebElement getemail() {
		return email;
	}
	
	@FindBy(id="CreatePassword")
	WebElement password;
	
	public WebElement createpassword() {
		return password;
	}
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement createacc;
	
	public WebElement getcreateaccount() {
		return createacc;
	}
	
}
