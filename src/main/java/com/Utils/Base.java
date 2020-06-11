package com.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Base {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = Logger.getLogger(Base.class);

	public Base() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\Config\\config.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		driver = null;
		System.out.println("Initializing Driver");
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			log.info("Launching the Browser");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			System.setProperty("webdriver.chrome.driver",
					"D:\\Projects\\CrestCucumber\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver(cap);
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='90%'");

		log.info("Lauching the URL");
		driver.get(prop.getProperty("url"));
		System.out.println(driver.getCurrentUrl());

	}

}
