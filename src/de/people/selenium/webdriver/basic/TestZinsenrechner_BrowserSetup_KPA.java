package de.people.selenium.webdriver.basic;


import java.io.File;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class TestZinsenrechner_BrowserSetup_KPA {

	static String browser;
	static WebDriver driver;

	public String setBrowser(Properties prop) {

		browser = prop.getProperty("browser");
		System.out.println("Mein Browser: " + browser);
		return browser;

	}

	public WebDriver setBrowserConfig(String browser, Properties prop) {

		// String browserOrt_bekannt;
		String noString = new String("no");
		String browserOrt_bekannt = new String("no");
		browserOrt_bekannt = prop.getProperty("browser_binary_known"); // Hanlding
																		// wenn
																		// Browser
																		// exe
																		// Ort
																		// nicht
																		// bekannt

		// Configuration for Firefox browser

		System.out.println("im BrowserSetpu " + browserOrt_bekannt);
		System.out.println("Schrit 2a");
		System.out.println("Binary gesetzt auf " + prop.getProperty("browser_binary_FF"));
		System.out.println("Schrit 2b");
		if (browser.contains("Firefox")) {

			System.out.println("Schrit 2c");
			if (browserOrt_bekannt.equals(noString)) {
				// Eclipse kann Firefox Binary nicht finden
				System.setProperty("webdriver.firefox.marionette", prop.getProperty("firefoxDriverLocation"));
				System.out.println("Schrit 2a");
				File pathToBinary = new File(prop.getProperty("browser_binary_FF"));

				System.out.println("Binary gesetzt auf " + prop.getProperty("browser_binary_FF"));
				System.out.println("Schrit 3");
				FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
				System.out.println("Schrit 3a");
				FirefoxOptions options = new FirefoxOptions().setProfile(new FirefoxProfile());
				System.out.println("Schrit 3b");
				options.setBinary(ffBinary);
				System.out.println("Schrit 3c");
				driver = new FirefoxDriver(options);
				System.out.println("Schrit 3c1");
			} else {
				System.out.println("Schrit 3d");
				System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxDriverLocation"));
				System.out.println("Schrit 3e");
				driver = new FirefoxDriver();
			}

		}

		// Configuration for Chrome browser
		if (browser.contains("Chrome")) {

			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverLocation"));
			System.out.println("Schrit 4");
			if (browserOrt_bekannt.equals(noString)) {
				// Eclipse kann Chrome Binary nicht finden
				System.out.println("Schrit 4a");
				File pathToBinary = new File(prop.getProperty("browser_binary_CH"));
				System.out.println("Binary gesetzt auf " + prop.getProperty("browser_binary_CH"));
				System.out.println("Schrit 4b");
				ChromeOptions options = new ChromeOptions();
				options.setBinary(pathToBinary);
				System.out.println("Schrit 4.c");
				driver = new ChromeDriver(options);

			} else {
				System.out.println("Schrit 4.d");
				driver = new ChromeDriver();
			}

		}
		driver.manage().window().maximize();

		// driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*
		 * The implicit wait will tell the WebDriver to wait a certain amount of
		 * time before it throws a "No Such Element Exception The default
		 * setting of implicit wait is zero. Once you set the time, the web
		 * driver will wait for that particular amount of time before throwing
		 * an exception."
		 * 
		 * Wenn ich warten möchte, weil z.B. ein Login etwas dauert, dann muss
		 * ein expliziter Wait gemacht werden wie Tread.sleep oder new
		 * WebDriverWait
		 */
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		return driver;
	}

}
