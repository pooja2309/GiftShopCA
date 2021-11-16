package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Readproperty {

	static Properties config;

	public Readproperty() {
		config = new Properties();
		FileInputStream fs = null;

		try {
			fs = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fs);
			config.getProperty("browser");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// retrieves driver from config.properties file
	public String getdriver() {
		String browser = config.getProperty("browser");
		System.out.println(config.getProperty("browser"));
		if (browser != null) {
			return browser;
		} else {
			throw new RuntimeException("No browser mentioned...");
		}
	}

	// retrieves the url from config.properties file
	public String getUrl() {
		String url = config.getProperty("url");
		if (url != null) {
			return url;
		} else {
			throw new RuntimeException("URL Not specified");
		}
	}

	public String pathsheet() {
		String path = config.getProperty("pathtosheet");
		if (path != null) {
			return path;
		} else {
			throw new RuntimeException("No path to excel sheet..");
		}
	}

}
