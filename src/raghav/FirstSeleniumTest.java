package raghav;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSeleniumTest {
	/*
	 * According to Raghav Pal's YouTube video
	 */
	static String browser;
	static WebDriver driver;

	public static void main(String[] args) {

		setBrowser();
		setBrowserConfig();
		runTest();

	}

	public static void setBrowser(){
		
		//browser = "Firefox";
		browser = "Chrome";
	}

	public static void setBrowserConfig(){
		
		//Configuration for Firefox browser
		if(browser.contains("Firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\A307951\\Selenium\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		//Configuration for Chrome browser
		if(browser.contains("Chrome")){
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\A307951\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	}

	public static void runTest(){

		driver.get("http://seleniumhq.org/");

	}

}
