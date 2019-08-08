package de.people.selenium.webdriver.basic;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Zinsenrechner_Testfall3 {

	/*
	 * in der Klasse werden die Testdaten aus einem xls eingelesen
	 * 
	 */

	void Testfall3_Read_XLS(WebDriver driver, Properties prop) {

		String myURL = prop.getProperty("url");
		String meineTestdaten = System.getProperty("user.dir") + "\\Zinsenrechner_Testfall3.csv";
		KPA_XLS_Testdata testdatenZR = new KPA_XLS_Testdata();

		String Eingabe_alsText;
		String Eingabe_alsText2;

		String Ausgabe_alsText;
		String Ausgabe_alsText2;

		Double Eingabe = 0.0;
		Double Ausgabe = 0.0;

		int Vergleich = 0;

		try {

			System.out.println("Schritt 1 und die URL: " + myURL);
			driver.get(myURL);
			System.out.println("Schritt 2");
			System.out.println("Pfad: " + meineTestdaten);
			Eingabe_alsText = testdatenZR.getXLSfile(meineTestdaten);
			if (Eingabe_alsText != "Fehler123") {
			// ************** Anfangskapital eintragen*******************
			// ich möchte sehen, was in dem Feld enthalten ist
			// System.out.println("IM feld steht" +
			// driver.findElement(By.xpath("//input[@name='anfangskapital']")).getText());

			driver.findElement(By.xpath("//input[@name='anfangskapital']")).clear();
			System.out.println("Schritt 3");
			driver.findElement(By.xpath("//input[@name='anfangskapital']")).click();

			System.out.println("Initialwert: " + Eingabe_alsText);
			driver.findElement(By.xpath("//input[@name='anfangskapital']")).sendKeys(Eingabe_alsText);
			System.out.println("Schritt 4");
			// ************** WebElement - Button - Klick *******************
			System.out.println("Schrit 5");
			driver.findElement(By.name("berechnen")).click();
			System.out.println("Schritt 6");

			// ************** Ergebnis prüfen *******************************
			// Eingabe_alsText =
			// driver.findElement(By.xpath("//input[@name='anfangskapital']")).getText();
			// System.out.println("Eingabe als Text nicht konvertiert " +
			// Eingabe_alsText);

			WebElement TabellenEintrag = driver.findElement(By.xpath("//table[@class='verlauf']/tbody/tr[2]/td[2]"));
			System.out.println("Schritt 7");
			System.out.println("Inhalt der Tabelle: " + TabellenEintrag.getText());

			// hier muss der Eintrag aus dem Feld 'Anfangskapital' übernommen
			// werden
			// wenn die Eingabe falsch war dann wird der Eintrag beim Berechnen
			// mit 1,00 ersetzt
			// Eingabe_alsText =
			// driver.findElement(By.xpath("//input[@name='anfangskapital']")).getText();
			// 1000.00 in 1000,00 umwandeln

			Eingabe_alsText2 = Eingabe_alsText.replace(".", "");
			Eingabe_alsText2 = Eingabe_alsText2.replace(",", ".");
			System.out.println("Eingabe als Text konvertiert " + Eingabe_alsText);
			Eingabe = Double.parseDouble(Eingabe_alsText2);

			Ausgabe_alsText = TabellenEintrag.getText();
			Ausgabe_alsText2 = Ausgabe_alsText.replace(".", "");
			Ausgabe_alsText2 = Ausgabe_alsText2.replace(",", ".");
			System.out.println("Eingabe als Text konvertiert " + Ausgabe_alsText2);
			Ausgabe = Double.parseDouble(Ausgabe_alsText2);

			System.out.println("Schritt 8");
			Vergleich = Double.compare(Eingabe, Ausgabe);
			System.out.println("Schritt 9");

			if (Vergleich == 0)
				System.out.println("Eingabe und Ausgabe sind gleich \n");
			else
				System.out.println("Eingabe und Ausgabe sind nichts gleich \n");
			} else {
				System.out.println("Fehler beim Lesen der Datei mit Testdaten \n");
			}

		} catch (Exception e) {

			System.out.print(e);
			System.out.println("Testfall1 beendet mit Exception");

		}

	}
}
