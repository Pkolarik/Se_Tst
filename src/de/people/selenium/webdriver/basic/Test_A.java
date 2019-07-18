package de.people.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_A {
	
	WebDriver driver;
	
	public void invokeBrowser(){
		String projectLocation = System.getProperty("user.dir");
		
		try {
			System.setProperty("webdriver.chrome.driver", projectLocation+"\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			/*driver.manage().deleteAllCookies();*/
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("https://www.edureka.co");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		Test_A myObj = new Test_A();
		myObj.invokeBrowser();
		/*myObj.searchCourse();*/

	}


/*public void searchCourse() {
	
	driver.findElement(By.id("search-inp1")).sendKeys("Java");
	
}*/

}