package de.people.selenium.webdriver.basic;
/*
 * Diese Klasse ist die TEst Suite von Katharina enthalten
 * Die Klasse enthält main();
 * Der Name TestZinsenrechner ist nicht ganz richtig.
 * Aus der Klasse lassen sich unterschiedliche Webseiten test
 * Die Klasse ist gleich wie TestZinsenrechner_Einstieg bis auf den Aufruf der
 * Test-Klassen (das ist eben individuel)
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class TestZinsenrechner_Einstieg_KPA {

	static Properties prop_win = new Properties();

	static TestZinsenrechner_BrowserSetup_KPA zrBrowserWin = new TestZinsenrechner_BrowserSetup_KPA();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String projectLocation_win = System.getProperty("user.dir");
		String myBrowser;
		WebDriver myDriver;
		// ZinsenRechner_Testfall1 MeinTestfall = new ZinsenRechner_Testfall1();
		// KPA_Testfall_2_ChessBase MeinTestfall_ChessBase = new
		// KPA_Testfall_2_ChessBase();
		// Zinsenrechner_Testfall3 MeinTestfall = new Zinsenrechner_Testfall3();

		Zinsenrechner_Testfall4 MeinTestfall = new Zinsenrechner_Testfall4();
		TestZinsenrechner_Ausstieg Ausstieg = new TestZinsenrechner_Ausstieg();

		System.out.println("ProjectLocation ist: " + projectLocation_win); // /Users/kasia2/git/Se_Tst
		readDataFile_win(projectLocation_win);
		myBrowser = zrBrowserWin.setBrowser(prop_win);

		System.out.println("Mein Browser: " + myBrowser);
		myDriver = zrBrowserWin.setBrowserConfig(myBrowser, prop_win);
		// MeinTestfall.Testfall1_defaultEinstellungen(myDriver, prop_win);
		// MeinTestfall_ChessBase.Testfall1_defaultEinstellungen(myDriver,
		// prop_win);
		// MeinTestfall.Testfall3_Read_XLS(myDriver, prop_win);
		System.out.println("Vor dem Testfall4");
		MeinTestfall.Testfall4_Read_DB(myDriver, prop_win);

		// myDriver beenden
		Ausstieg.tearDown(myDriver);

	}

	public static void readDataFile_win(String projectLoc) {
		try {
		 
			InputStream input = new FileInputStream(projectLoc+"/src/de/people/selenium/webdriver/basic/data.properties");
			System.out.println("Input ist: "+input);
			prop_win.load(input);
			System.out.println("Mein Browser: "+prop_win.getProperty("browser"));
			//System.out.println("Mein Login Name: "+prop_mac.getProperty("username"));
			
				

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
