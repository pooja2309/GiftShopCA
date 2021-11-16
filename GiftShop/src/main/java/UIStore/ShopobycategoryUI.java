package UIStore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopobycategoryUI {
	public WebDriver driver;

	public ShopobycategoryUI(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@name='sortBy']")
	WebElement sortby;
	
	public WebElement getsortby() {
		return sortby;
	}
}
