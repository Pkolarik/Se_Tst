package raghav;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Decidalo {

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
			InputStream input = new FileInputStream(projectLocation+"\\src\\raghav\\data.properties");
			prop.load(input);
			System.out.println(prop.getProperty("browser"));
			System.out.println(prop.getProperty("username"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setBrowser(){

		browser = prop.getProperty("browser");
	}

	public static void setBrowserConfig(){

		//String projectLocation = System.getProperty("user.dir");

		System.out.println(projectLocation);

		//Configuration for Firefox browser
		if(browser.contains("Firefox")){
			System.setProperty("webdriver.gecko.driver", projectLocation+"\\geckodriver-v0.24.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		//Configuration for Chrome browser
		if(browser.contains("Chrome")){
			System.setProperty("webdriver.chrome.driver", projectLocation+"\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();

		}
	}

	public static void runTest()  {
		
		driver.get("https://decidalo.telekom.de/");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("btnLogin")).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.findElement(By.className("start-page-description")).click();
		System.out.println("Alles in Ordnung");
	} 
}


