package de.people.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGetCommands {
	
	WebDriver driver; //ctrl+shift+o

	public void invokeBrowser(){
		String projectLocation = System.getProperty("user.dir");
		
		try {
			System.setProperty("webdriver.chrome.driver", projectLocation+"\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			getCommands();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void getCommands(){
		try {
			driver.get("http://www.amazon.de");
			String titleOfThePage = driver.getTitle();
			System.out.println("Title of the page is: "+titleOfThePage);
			driver.findElement(By.linkText("Angebote")).click();
			String currentUrl = driver.getCurrentUrl();
			System.out.println("The current URL is: "+currentUrl);
			//System.out.println("The current page source is: "+driver.getPageSource());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestGetCommands myObj = new TestGetCommands();
		myObj.invokeBrowser();

		
		
	}

}


