package de.people.selenium.webdriver.basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestZinsenrechner_Einstieg_mac {
		

	static Properties prop_mac = new Properties();
	
	static TestZinsenrechner_BrowserSetup zrBrowserMac = new TestZinsenrechner_BrowserSetup();
	
	




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String projectLocation_mac = System.getProperty("user.dir");
		String myBrowser;
		WebDriver myDriver;
		

		ZinsenRechner_Testfall1  MeinTestfall = new ZinsenRechner_Testfall1 (); 
		TestZinsenrechner_Ausstieg Ausstieg = new TestZinsenrechner_Ausstieg ();
		
		
		System.out.println("ProjectLocation ist: "+ projectLocation_mac); // /Users/kasia2/git/Se_Tst
		readDataFile_mac(projectLocation_mac);
		myBrowser = zrBrowserMac.setBrowser(prop_mac);
		
		System.out.println("Mein Browser: "+ myBrowser); 
		myDriver = zrBrowserMac.setBrowserConfig(myBrowser, prop_mac);
		MeinTestfall.Testfall1_defaultEinstellungen(myDriver, prop_mac);	
		//Driver beenden
		Ausstieg.tearDown(myDriver);
		
	}
	
	public static void readDataFile_mac(String projectLoc){
		try {
		 
			InputStream input = new FileInputStream(projectLoc+"/src/de/people/selenium/webdriver/basic/data.properties");
			System.out.println("Input ist: "+input);
			prop_mac.load(input);
			System.out.println("Mein Browser: "+prop_mac.getProperty("browser"));
			System.out.println("Mein Login Name: "+prop_mac.getProperty("username"));
			
			
			
				
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	
}
