package UIStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalizedpageUI {
	public WebDriver driver;

	public PersonalizedpageUI(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(),'Personalized Harry Potter Themed Nameplate | COD not available')]")
	WebElement personalizedproduct;
	
	public WebElement getpersonalizedproduct() {
		return personalizedproduct;
	}
	
	@FindBy(xpath="//input[@type='text']")
	WebElement name;
	
	public WebElement getname() {
		return name;
	}
	
	@FindBy(xpath="//*[@name='add']")
	WebElement addtocart;
	
	public WebElement getaddtocart() {
		return addtocart;
	}
	
	@FindBy(xpath="//*[contains(text(),'Shopping Cart')]//following::h2")
	WebElement verificationmsg;
	
	public WebElement getverification() {
		return verificationmsg;
	}
}
