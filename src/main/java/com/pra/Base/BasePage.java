package com.pra.Base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public WebDriver driver;

	// initialize driver on the bases of browser
	public WebDriver initializing_driver(String browser) {
		// String browser="chrome";
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.get("http://www.facebook.com");

		return driver;
	}

	public void quit_Browser() {
		try {
		driver.quit();
		}catch(Exception e) {
			System.out.println("some exception occured while quitting the browser");
		}
	}

	public void close_Browser() {
		try {
		driver.close();
		}catch(Exception e) {
			System.out.println("some exception occured while closing the browser");
		}
	}

}
