package raghav;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Decidalo {

	static String browser;
	static WebDriver driver;

	public static void main(String[] args) {

		setBrowser();
		setBrowserConfig();
		runTest();

	}

	public static void setBrowser(){

		browser = "Firefox";
		//browser = "Chrome";
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

		driver.get("https://decidalo.telekom.de/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("Pavel.Kolarik@t-systems.com");
		driver.findElement(By.id("password")).sendKeys("Celadna_693");
		driver.findElement(By.id("btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.findElement(By.className("start-page-description")).click();
		System.out.println("Alles in Ordnung");
	}

}
