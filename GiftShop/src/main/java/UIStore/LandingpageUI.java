package UIStore;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingpageUI {
	public WebDriver driver;

	public LandingpageUI(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[contains(text(),' Corporate Gifts ')]")
	WebElement corporategift;
	
	public WebElement getcorporategift() {
		return corporategift;
	}
	
	@FindBy(xpath="//*[contains(text(),' Personalized Gifts ')]")
	WebElement personalized;
	
	public WebElement getpersonalized() {
		return personalized;
	}
	
	@FindBy(xpath="//*[contains(text(),' Shop by Category ')]")
	WebElement shopbycategory;
	
	public WebElement getshopbycategory() {
		return shopbycategory;
	}
	
	@FindBy(xpath="//*[contains(text(),' Face Masks')]")
	WebElement facemask;
	
	public WebElement getfacemaskfromdropdown() {
		return facemask;
	}
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchbox;
	
	public WebElement getsearchbox() {
		return searchbox;
	}
	
	@FindBy(xpath="//*[contains(text(),'sign in')]")
	WebElement signup;
	
	public WebElement getsignup() {
		return signup;
	}
	
	@FindBy(xpath="//*[contains(text(),'wish list')]")
	WebElement wishlist;
	
	public WebElement getwishlist() {
		return wishlist;
	}
	
	@FindBy(xpath="//*[contains(text(),'gift card')]")
	WebElement giftcard;
	
	public WebElement getgiftcard() {
		return giftcard;
	}
	
	@FindBy(id="Email")
	WebElement emailnewsletter;
	
	public WebElement getemailfornewsletter() {
		return emailnewsletter;
	}
	
	
}
