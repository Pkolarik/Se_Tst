package de.people.selenium.webdriver.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestZinsenrechner_Einstieg {
	
    static Properties prop_windows = new Properties();
	static TestZinsenrechner_BrowserSetup zrBrowserWindows = new TestZinsenrechner_BrowserSetup();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String projectLocation_windows = System.getProperty("user.dir");
		String myBrowser;
		WebDriver myDriver;

		//ZinsenRechner_Testfallxxx  meinTestfall = new ZinsenRechner_Testfallxxx (); 
		
		//
		
		System.out.println("ProjectLocation ist: "+ projectLocation_windows); 
		readDataFile_windows(projectLocation_windows);
		myBrowser = zrBrowserWindows.setBrowser(prop_windows);
		
		System.out.println("Mein Browser: "+ myBrowser); 
		myDriver = zrBrowserWindows.setBrowserConfig(myBrowser, prop_windows);
		//meinTestfall.Testfallxxx_defaultEinstellungen(myDriver, prop_windows);
			
		
	}
	
	public static void readDataFile_windows(String projectLoc){
		try {
		 
			InputStream input = new FileInputStream(projectLoc+"/src/de/people/selenium/webdriver/basic/data.properties");
			System.out.println("Input ist: "+input);
			prop_windows.load(input);
			System.out.println("Mein Browser: "+prop_windows.getProperty("browser"));
			System.out.println("Mein Login Name: "+prop_windows.getProperty("username"));
						
			
				
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
	
