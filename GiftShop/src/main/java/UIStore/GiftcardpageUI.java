package UIStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftcardpageUI {
	public WebDriver driver;

	public GiftcardpageUI(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "add")
	WebElement addtocart;
	
	public WebElement getaddtocart() {
		return addtocart;
	}
	
	@FindBy(id = "PostalCode")
	WebElement pincode;
	
	public WebElement getpin() {
		return pincode;
	}
	
	@FindBy(xpath="//*[contains(@class, 'codbutton btn button')]")
	WebElement checkpinbtn;
	
	public WebElement checkpin() {
		return checkpinbtn;
	}
	
	@FindBy(id="PostalCodeCheckerAvailability")
	WebElement CODAvailability;
	public WebElement getavailability() {
		return CODAvailability;
	}
	
	@FindBy(xpath="//*[contains(@class,'swym-wishlist-cta')]")
	WebElement Addtowishlist;
	public WebElement addtowishlists() {
		return Addtowishlist;
	}
	
}
