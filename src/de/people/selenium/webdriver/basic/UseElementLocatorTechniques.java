package de.people.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UseElementLocatorTechniques {

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

public void closeBrowser() {
	driver.close();
}
	
	public void elementLocatorTechniques() {
		try {
			invokeBrowser("http://www.amazon.de");
			//driver.findElement(By.linkText("Hallo! Anmelden")).click();
			//driver.navigate().back();
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Netzwerkspeicher");
			driver.findElement(By.className("nav-input")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		UseElementLocatorTechniques obj = new UseElementLocatorTechniques();
		obj.elementLocatorTechniques();

	}

}
