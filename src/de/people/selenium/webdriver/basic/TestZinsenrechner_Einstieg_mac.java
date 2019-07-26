package de.people.selenium.webdriver.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestZinsenrechner_Einstieg_mac {
	

	
static String browser_mac;
static WebDriver driver_mac;
static String projectLocation_mac = System.getProperty("user.dir");
static Properties prop_mac = new Properties();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("ProjectLocation ist: "+ projectLocation_mac); // /Users/kasia2/git/Se_Tst
		readDataFile_mac();
	}
	
	public static void readDataFile_mac(){
		try {
		 
			InputStream input = new FileInputStream(projectLocation_mac+"/src/de/people/selenium/webdriver/basic/data.properties");
			System.out.println("Input ist: "+input);
			prop_mac.load(input);
			System.out.println("Browser: "+prop_mac.getProperty("browser"));
			System.out.println("Login Name: "+prop_mac.getProperty("username"));
			
			
				
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	
}
