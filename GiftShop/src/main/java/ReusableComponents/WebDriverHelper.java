package ReusableComponents;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebDriverHelper {

	WebDriver driver;

	// Initializing the driver
	public WebDriverHelper(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	}

	// open the chrome browser with given url
	public void openwebsite(String url) {
	// TODO Auto-generated method stub
	driver.get(url);
	}

	// navigate control to the new driver - iterate over the windows
	public WebDriver changetonewdriver(WebDriver driver) throws InterruptedException {
	Set<String> id = driver.getWindowHandles();
	Iterator<String> iter = id.iterator();
	Thread.sleep(2000);
	driver.switchTo().window(iter.next());
	return driver;
	}

}
