package com.edureka.selenium.webdriver.gecko;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_B {
	WebDriver driver;
	
	public void invokeBrowser(String url){
		String projectLocation = System.getProperty("user.dir");
		try {
			System.setProperty("webdriver.gecko.driver", projectLocation+"\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get(url);
			System.out.println("von Katharina");

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
 
	
	public static void main(String[] args) {
		Test_B obj = new Test_B();
		obj.invokeBrowser("https://www.franzis.de");

	}

}
