package de.people.selenium.webdriver.basic;
/* Testfall von Katharina 
 * In dieser Klasse wird die Web-Seite https://de.chessbase.com/
	getestet
 * 
 */

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KPA_Testfall_2_ChessBase {

	public void Testfall1_defaultEinstellungen(WebDriver driver, Properties prop) {

		String myURL = prop.getProperty("urlchess");

		try {
			System.out.println("Schritt 1 und die URL: " + myURL);
			driver.get(myURL);
			System.out.println("Schritt 2");
			// ************** Anfangskapital eintragen*******************
			// ich möchte sehen, was in dem Feld enthalten ist
			// System.out.println("IM feld steht" +
			// driver.findElement(By.xpath("//input[@name='anfangskapital']")).getText());

			// driver.findElement(By.xpath("//a[@onclick='return
			// onShowHideSearchClick()' and @href= '#']")).click();
			// driver.findElement(By.xpath("//img[@class='svg grpelem' and @id=
			// 'container-top-suche']//parent::a")).click();
			driver.findElement(By
					.xpath("//img[@class='svg grpelem' and @id= 'container-top-suche' and @src='/images/suchen.svg']"))
					.click();

		} catch (Exception e) {

			System.out.print(e);
			System.out.println("Testfall1 beendet mit Exception");

		}

	}

}
