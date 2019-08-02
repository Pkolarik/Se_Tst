package de.people.selenium.webdriver.basic;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class  TestZinsenrechner_BrowserSetup {
	
	static String browser;
	static WebDriver driver;
	
	
	public String setBrowser(Properties prop){

		browser = prop.getProperty("browser");
		System.out.println("Mein Browser: "+ browser); 
		return browser;
		
	}
	
   public WebDriver setBrowserConfig(String browser, Properties prop){

		

		//Configuration for Firefox browser
		if(browser.contains("Firefox")){
			
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxDriverLocation"));
			driver = new FirefoxDriver();
		}

		//Configuration for Chrome browser
		if(browser.contains("Chrome")){
			
			
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverLocation"));
			driver = new ChromeDriver();
		
		}
		driver.manage().window().maximize();


       // driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        /*The implicit wait will tell the WebDriver to wait a certain amount of time before it throws
         *  a "No Such Element Exception.” The default setting of implicit wait is zero. 
         *  Once you set the time, the web driver will wait for that particular amount of time before throwing an
         *   exception."
         *   
         *   Wenn ich warten möchte, weil z.B. ein Login etwas dauert, dann muss ein expliziter Wait gemacht werden
         *   wie Tread.sleep oder new WebDriverWait
         */
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
		return driver;
	}

}
