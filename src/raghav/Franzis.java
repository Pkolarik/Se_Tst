package raghav;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Franzis {

	static String browser;
	static WebDriver driver;
	static String projectLocation = System.getProperty("user.dir");
	static Properties prop = new Properties();

	public static void main(String[] args){

		readDataFile();
		setBrowser();
		setBrowserConfig();
		runTest();

	}


	public static void readDataFile(){
		try {
			
			InputStream input = new FileInputStream(projectLocation+"/src/raghav/data.properties");
			
			prop.load(input);
			System.out.println("Browser: "+prop.getProperty("browser"));
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public static void setBrowser(){

		browser = prop.getProperty("browser");
	}

	public static void setBrowserConfig(){

		
		System.out.println("Projekt: "+projectLocation);
		System.out.println("Drivers befinden sich in: "+prop.getProperty("driverLocation"));

		//Configuration for Firefox browser
		if(browser.contains("Firefox")){
			
			System.setProperty("webdriver.gecko.driver", prop.getProperty("firefoxDriverLocation"));
			driver = new FirefoxDriver();
		}

		//Configuration for Chrome browser
		if(browser.contains("Chrome")){
			
			System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverLocation"));
			driver = new ChromeDriver();

		}
	}

	public static void runTest()  {
		
		driver.get(prop.getProperty("franzisUrl"));
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.findElement(By.className("main-search--field")).sendKeys("COACH");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@href='https://www.franzis.de/search?sSearch=COACH']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//select[@name='o']")).sendKeys("Erscheinungsdatum");
		//Funktioniert so nur f�r Chrome, nicht aber f�r Firefox!
		
		js.executeScript("window.scrollBy(0,500)");
		
		System.out.println("Alles in Ordnung");
	} 
}


