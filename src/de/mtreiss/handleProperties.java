package de.mtreiss;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class handleProperties {
	
	private Properties prop = new Properties();
	private String projectLoc;
	
	handleProperties() {
	}
	
	public String getProjectLog() {
		projectLoc = System.getProperty("user.dir");
		System.out.println(projectLoc);
		return projectLoc;
	}
	

	//* Liest die Datei data Properties
	public Properties getProperties(String projectLoc) {
	try {
		prop.load(new FileInputStream(projectLoc+"/src/de/mtreiss/data.properties"));	
		System.out.println("Properties sind eingelesen.");
		}
	catch (FileNotFoundException e) {System.out.println("FNF Exception found."); }
	catch (IOException e) {System.out.println("IO Exception found."); }
	return prop;
	}
	
	// Gebe die Einzelfelder zurück
	
	// Ermittle ob Firefox oder Chrome Browser
	public String getBrowser(){
		return prop.getProperty("browser");
	}
	
	public String getFirefoxDriverLocation() {
		return prop.getProperty("firefoxDriverLocation");
	}

	public String getChromeDriverLocation() {
		return prop.getProperty("ChromeDriverLocation");
	}

	public String getUrl() {
		return prop.getProperty("zinsrechnungUrl");
	}
	
}





// Zeilenspeicher
/*
 * 		System.out.println("Browser ist: "+prop.getProperty("browser"));
*		System.out.println("Browser ist: "+prop.getProperty("driverLocation"));
*		System.out.println("Browser ist: "+prop.getProperty("username"));
*		System.out.println("Browser ist: "+prop.getProperty("password"));
*		System.out.println("Browser ist: "+prop.getProperty("ChromeDriverLocation"));
*		System.out.println("Browser ist: "+prop.getProperty("firefoxDriverLocation"));
*		System.out.println("Browser ist: "+prop.getProperty("ciamPassword"));
*		System.out.println("Browser ist: "+prop.getProperty("ciamUsername"));
*		System.out.println("Browser ist: "+prop.getProperty("browser"));
*		System.out.println("Browser ist: "+prop.getProperty("decidaloURL"));
*/