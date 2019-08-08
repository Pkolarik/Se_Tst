package pavel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class handleBrowser {
	
private WebDriver driver;
	
	handleBrowser(String browser, String firefoxDriverLocation, String chromeDriverLocation) {
		
		// Auswahl des Browsertyps
		if(browser.contains("Firefox")){
			System.setProperty("webdriver.gecko.driver", firefoxDriverLocation);
			driver = new FirefoxDriver();
			//System.out.println("Firefox"+ baseUrl);
			
		}
		if(browser.contains("Chrome")){	
			/*System.out.println("X"+ Url);*/
			System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
			
			driver = new ChromeDriver();}
		System.out.println("Browsertreiber ist ausgewählt: " + browser);
		// Aufruf des ermittelten Browsers
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
	}

	// Gebe den Driver zurück
		public WebDriver getDriver(){
			return driver;
		}
		

}
