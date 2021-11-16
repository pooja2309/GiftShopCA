package Utility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Extentreports {

	static ExtentTest test;
	static ExtentReports report;
	WebDriver driver;
	Screenshots ss = new Screenshots();

	public Extentreports(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	report = new ExtentReports(System.getProperty("user.dir") + "\\Reports\\ExtentReportResults.html");
	}

	public void startTest(String name) {
	test = report.startTest(name);
	try {
	test.log(LogStatus.PASS, test.addScreenCapture(ss.capture(driver)) + " Test Passed - " + name);
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();

	}
	}

	public void endTest() {
	report.endTest(test);
	report.flush();
	}
}
