package Runner;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjects.CorporateGifts;
import PageObjects.CreateAccount;
import PageObjects.GiftCard;
import PageObjects.Login;
import PageObjects.Newsletter;
import PageObjects.PersonalizedGift;
import PageObjects.SearchService;
import PageObjects.Shopbycategory;
import PageObjects.WishList;
import ReusableComponents.WebDriverHelper;
import UIStore.CorporategiftpageUI;
import UIStore.GiftcardpageUI;
import UIStore.LandingpageUI;
import UIStore.LoginpageUI;
import UIStore.PersonalizedpageUI;
import UIStore.ShopobycategoryUI;
import Utility.Extentreports;
import Utility.Readproperty;

public class GiftShopRunner {
	static Readproperty rp = new Readproperty();
	static WebDriver driver = null;
	WebDriverHelper helper = null;
	Extentreports er;
	String wurl;
	LandingpageUI lploc;
	LoginpageUI loginpageloc;

	private static Logger log = LogManager.getLogger(GiftShopRunner.class.getName());

	// Sets the chrome driver by fetching info from config.properties
	@Test
	public void setdriver() {
		String browser = rp.getdriver();
		if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(System.getProperty("user.dir"));

			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\Driver\\chromedriver.exe");

			driver = new ChromeDriver();

			helper = new WebDriverHelper(driver);
			log.info("getting browser name");
			er = new Extentreports(driver);
		}
	}

	// Opens the url in chrome browser
	@Test(dependsOnMethods = { "setdriver" })
	public void openwebsite() {
		String url = rp.getUrl();
		wurl = url;
		helper.openwebsite(url);
		lploc = new LandingpageUI(driver);
		log.info("setting chrome driver and opening website");
	}

	@Test(dataProvider = "getCredentials", dependsOnMethods = { "openwebsite" })
	public void searchprods(String path) throws InterruptedException, IOException {

		System.out.println("Search products here");
		SearchService search = new SearchService(driver);
		search.getproducts(path);
		search.searchforproducts(er);
		log.info("Searched products from excel sheet");
	}

	@DataProvider
	public Object[][] getCredentials() {
		Object[][] data = new Object[1][1];
		data[0][0] = System.getProperty("user.dir") + rp.pathsheet();
		return data;
	}

	@Test(dependsOnMethods = { "searchprods" })
	public void corporategift() throws InterruptedException {
		driver = helper.changetonewdriver(driver);
		CorporateGifts cg = new CorporateGifts(driver, er);
		CorporategiftpageUI cgloc = new CorporategiftpageUI(driver);
		cg.clickoncorporategift(lploc);
		cg.enterdetails(cgloc);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver = helper.changetonewdriver(driver);
		// cg.verification(cgloc);
		log.info("Corporate Gifts entry successful");
	}

	// Personalized Gifts
	@Test(dependsOnMethods = { "corporategift" })
	public void personalized() throws InterruptedException {

		// Locators for Personalized gifts
		driver.get(wurl);
		PersonalizedpageUI pploc = new PersonalizedpageUI(driver);
		PersonalizedGift pg = new PersonalizedGift(driver, er);
		pg.clickonpersonalizedgift(lploc);
		pg.addproduct(pploc);
		driver = helper.changetonewdriver(driver);
		pg.verify(pploc);
		driver.get(wurl);
		log.info("Added personalized gift successfully");
	}

	
	@Test(dependsOnMethods = { "login" })
	public void createaccount() throws InterruptedException {
		loginpageloc = new LoginpageUI(driver);
		CreateAccount newacc = new CreateAccount(driver, er);
		driver.get(wurl);
		newacc.clickonlogin(lploc);
		driver = helper.changetonewdriver(driver);
		newacc.clickoncreateaccount(loginpageloc);
		driver = helper.changetonewdriver(driver);
		newacc.enterdetails();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		System.out.println("Creating account");
		log.info("Creating Account");
		driver.get(wurl);
	}

	@Test(dependsOnMethods = { "personalized" })
	public void login() throws InterruptedException {
		loginpageloc = new LoginpageUI(driver);
		Login login = new Login(driver, er);
		driver.get(wurl);
		login.clickonlogin(lploc);
		driver = helper.changetonewdriver(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		login.entercorrectdetails(loginpageloc);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		log.info("Log into Account");

	}

	@Test(dependsOnMethods = { "createaccount" })
	public void giftcard() throws InterruptedException {
		driver.get(wurl);
		GiftcardpageUI gcploc = new GiftcardpageUI(driver);
		GiftCard gc = new GiftCard(driver, er);
		gc.clickongiftcard(lploc);
		driver = helper.changetonewdriver(driver);
		gc.checkCOD(gcploc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		gc.getAvailability(gcploc);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		gc.addtowishlist(gcploc);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		log.info("Gift cards - COD and Wishlist");
	}

	@Test(dependsOnMethods = { "giftcard" })
	public void openwishlist() throws InterruptedException {
		driver.get(wurl);
		WishList wl = new WishList(driver, er);
		wl.clickonwishlist(lploc);
		driver = helper.changetonewdriver(driver);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		log.info("Wish List");
	}

	@Test(dependsOnMethods = { "openwishlist" })
	public void newsletter() throws InterruptedException {
		driver.get(wurl);
		Newsletter nl = new Newsletter(driver, er);
		nl.subscribetonewsletter(lploc);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		log.info("Subscribed to Newsletter");
	}

	// Closure
	@AfterTest
	public void close() {
		log.info("Closure");
		driver.quit();
	}
}
