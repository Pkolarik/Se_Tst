package de.people.selenium.webdriver.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestZinsenrechner_Einstieg {
	
	static String browser;
	static WebDriver driver;
	static String projectLocation = System.getProperty("user.dir");
	static Properties prop = new Properties();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("ProjectLocation ist: "+ projectLocation); // /Users/kasia2/git/Se_Tst
		readDataFile();

	}
	
	public static void readDataFile(){
		try {
		 InputStream input = new FileInputStream(projectLocation+"\\src\\de\\people\\selenium\\webdriver\\basic\\data.properties");
			
			System.out.println("Input ist: "+input);
			prop.load(input);
			System.out.println("Browser: "+prop.getProperty("browser"));
			System.out.println("Login Name: "+prop.getProperty("username"));
			
			
				
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
