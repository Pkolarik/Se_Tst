package com.edureka.selenium.webdriver.gecko;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InternetAvailability {

	WebDriver driver;
	
	public void invokeBrowser(String url){
		String projectLocation = System.getProperty("user.dir");
		try {
			System.setProperty("webdriver.gecko.driver", projectLocation+"\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get(url);
			driver.findElement(By.className("scroll")).click();
			//driver.findElement(By.className("closenotification")).click();
			//driver.findElement(By.className("border")).click();
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public void fillInForm(){
		try {
			invokeBrowser("https://www.telekom.de/zuhause/dsl-vdsl-und-lte-verfuegbarkeit?popup=false");
			
			//driver.findElement(By.className("closenotification")).click();
			//driver.findElement(By.className("border")).click();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		InternetAvailability obj = new InternetAvailability();
		obj.fillInForm();

	}

}
