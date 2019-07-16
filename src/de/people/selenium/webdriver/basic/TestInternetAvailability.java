package de.people.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestInternetAvailability {
	
	WebDriver driver; // ctrl+shift+o

	public void invokeBrowser(String url) {

		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\A307951\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.get(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}

	public void fillInForm(){
		try {
			invokeBrowser("https://www.telekom.de/zuhause/dsl-vdsl-und-lte-verfuegbarkeit?popup=false");
			driver.findElement(By.className("closenotification")).click();
			driver.findElement(By.className("border")).click();
			
			//driver.findElement(By.id("dslCheckPLZ")).sendKeys("80997");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		TestInternetAvailability obj = new TestInternetAvailability();
		obj.fillInForm();

	}

}
