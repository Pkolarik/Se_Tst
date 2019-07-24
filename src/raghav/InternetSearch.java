package raghav;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InternetSearch {

	static String browser;
	static WebDriver driver;
	static String projectLocation = System.getProperty("user.dir");

	public static void main(String[] args) {

		readDataFile();
		setBrowser();
		setBrowserConfig();
		runTest();

	}

	public static void readDataFile(){
		try {
			InputStream input = new FileInputStream(projectLocation+"\\src\\raghav\\data.properties");
			prop.load(input);
			System.out.println("Browser: "+prop.getProperty("browser"));
			System.out.println("Login Name: "+prop.getProperty("username"));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
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

		driver.get("https://www.amazon.de");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Netzwerkspeicher");
		driver.findElement(By.className("nav-input")).click();

	}

}
