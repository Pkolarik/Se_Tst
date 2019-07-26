package de.people.selenium.webdriver.basic;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestZinsenrechner_BrowserSetup {
	
	static String browser;
	static WebDriver driver_mac;
	
	public static void setBrowser(Properties prop){

		browser = prop.getProperty("browser");
		System.out.println("Mein Browser: "+ browser); 

	}

}
