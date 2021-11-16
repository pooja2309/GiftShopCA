package Utility;

import java.io.File;
import java.io.IOException;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class Screenshots {

	public String capture(WebDriver driver) throws IOException {
		// TODO Auto-generated method stub
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File Dest = new File(System.getProperty("user.dir") + "\\Screenshots\\" + System.currentTimeMillis() + ".png");
		String completepath = Dest.getAbsolutePath();
		FileUtils.copyFile(scrFile, Dest);
		return completepath;

		}

}
