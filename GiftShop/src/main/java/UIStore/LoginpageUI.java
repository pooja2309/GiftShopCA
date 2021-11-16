package UIStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpageUI {
	public WebDriver driver;

	public LoginpageUI(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="CustomerEmail")
	WebElement loginemail;
	
	public WebElement getloginemail() {
		return loginemail;
	}
	
	@FindBy(id="CustomerPassword")
	WebElement loginpwd;
	
	public WebElement getloginpassword() {
		return loginpwd;
	}
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement login;
	
	public WebElement getloginsubmit() {
		return login;
	}
	
	@FindBy(id="customer_register_link")
	WebElement createacc;
	
	public WebElement getcreateaccount() {
		return createacc;
	}
	
	@FindBy(id="RecoverPassword")
	WebElement forgotpwd;
	
	public WebElement getforgotpassword() {
		return forgotpwd;
	}
	
	@FindBy(id="RecoverEmail")
	WebElement recoveryemail;
	
	public WebElement typerecorveryemail() {
		return recoveryemail;
	}
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement forgotpwdsubmit;
	
	public WebElement getforgotpasswordsubmitbtn() {
		return forgotpwdsubmit;
	}
}
