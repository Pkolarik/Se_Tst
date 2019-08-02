package com.edureka.selenium.webdriver.gecko;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonSearch {
	
	//public WebDriver driver;
	//
	
	public WebDriver invokeBrowser(String url){
		WebDriver driver;
		try {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\A307951\\Selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			//System.setProperty("webdriver.firefox.bin", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
			//System.setProperty("webdriver.firefox.marionette", "C:\\Users\\A307951\\Selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			System.out.println("Step 1");
			driver = new FirefoxDriver();
			System.out.println("Step 2");
			driver.manage().deleteAllCookies();
			System.out.println("Step 3");
			driver.manage().window().maximize();
			System.out.println("Step 4");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			System.out.println("Step 5");
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			System.out.println("Step 6");
			driver.get(url);
			System.out.println("Step 7");
			//driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Netzwerkspeicher");
		return driver;
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println("Fehler");
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void fillInForm(){
		WebDriver driver2;
		try {
			driver2 = invokeBrowser("https://www.amazon.de");
			System.out.println("Step 8");
			
			driver2.findElement(By.id("twotabsearchtextbox")).sendKeys("Altes Geld");
			System.out.println("Step 9");
			driver2.findElement(By.className("nav-input")).click();
			System.out.println("Step 10");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		AmazonSearch obj = new AmazonSearch();
		obj.fillInForm();
		
	}

}
