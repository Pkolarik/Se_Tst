package de.people.selenium.webdriver.basic;

//import java.math.BigDecimal;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;





public class ZinsenRechner_Testfall2 {
	/*
	 * In dieser Klasse wird die Web-Seite https://www.zinsen-berechnen.de/zinsrechner.php
	 * getestet
	 * Zugriff auf: Textfeld, Radiobutton, Listenfeld, Button, Tabelle
	 *
	 * Szenario:
	 * - Zahl in das Feld 'Anfangskapital' eintragen
	 * - Zinseszins Radiobutton auf 'nein'
	 * - Laufzeit am 'Monate'
	 * - auf Button 'Berechnen'drücken
	 * 
	 * Ergebnis prüfen: 
	 * Es wird verglichen:
	 * - der Eintrag im Feld 'Anfangskapital' 
	 * - mit dem Eintrag in der Tabelle Guthabenentwicklung in der Spalte 'angelegtes Kapital 
	 * zu Jahresbeginn' aus der ersten Zeile
     * Wenn die Einträge gleich sind, dann hat eine Berechnung stattgefunden
	 * Ob das Ergebnis der Berechnung richtig ist, wird nicht geprüft
	 * 
	 */
	
	public ZinsenRechner_Testfall2 (WebDriver driver, Properties prop) {
		Testfall1_defaultEinstellungen (driver, prop);
	}
	
	
	public void Testfall1_defaultEinstellungen(WebDriver driver, Properties prop){
		
	String myURL = prop.getProperty("url");
	String Eingabe_alsText = "3456,50";
	String Eingabe_alsText2;
	
	String Ausgabe_alsText;
	String Ausgabe_alsText2;
	
	Double Eingabe = 0.0;
	Double Ausgabe = 0.0;
	
	int Vergleich = 0; 
	
	
		
	System.out.println("Schritt 1 und die URL: " +myURL);	
	driver.get(myURL);
	System.out.println("Schritt 2");
	// ************** Anfangskapital eintragen*******************
    driver.findElement(By.xpath("//input[@name='anfangskapital']")).clear();
    System.out.println("Schritt 3");
    driver.findElement(By.xpath("//input[@name='anfangskapital']")).sendKeys(Eingabe_alsText);
    System.out.println("Schritt 4");
    
    // ************** WebElement Radio button*******************

    driver.findElement(By.xpath("//input[contains(@class,'f1radio') and contains(@value, 'nein')]")).click();

    
  // ************** WebElement - List - Laufzeit Einheit setzen *******************
  //Zugriff auf die Liste
    WebElement selectElement = driver.findElement(By.name("laufzeiteinheit"));
    //Zugriff auf die Listenelemente
    Select selectEinheit = new Select(selectElement);
    selectEinheit.selectByValue("12"); // setzen auf Monate
    
    //es folgt nur Rumspielen mit der Liste - 
    //Thread.sleep(2000);
    selectEinheit.selectByIndex(0); // begint mit 0 , setzen auf Jahre
    //Thread.sleep(2000);
    System.out.println("Schrit 4.1");
    selectEinheit.selectByVisibleText("Monate"); // setzen auf Monate

    List<WebElement> listeEinheiten = selectEinheit.getOptions(); 
    // wichtig import java.util.List; und nicht import java.awt.List oder etwas anderes
    // importieren
    System.out.println("Schrit 4.2");
    //ein Bsp.1 - was mit der Liste gemacht werden kann
    for (WebElement webEinheit : listeEinheiten) {

        System.out.println("WebEinheit: "+ webEinheit.getText());


    }
    System.out.println("Schrit 4.3");
  //ein Bsp.2 - was mit der Liste gemacht werden kann

    for (WebElement webEinheit : listeEinheiten) {

        if (webEinheit.getAttribute("value").equals("1")) {
            System.out.println("Schrit 4.4");
            webEinheit.click();
            System.out.println("Schrit 4.5");
        }
    }

 // ************** WebElement - Button - Klick *******************
    System.out.println("Schrit 5");
    driver.findElement(By.name("berechnen")).click();
    System.out.println("Schritt 6");
    
 // ************** Ergebnis prüfen *******************************
    Eingabe_alsText = driver.findElement(By.xpath("//input[@name='anfangskapital']")).getText();
    System.out.println("Eingabe als Text nicht konvertiert " + Eingabe_alsText);
    
    WebElement TabellenEintrag = driver.findElement(By.xpath("//table[@class='verlauf']/tbody/tr[2]/td[2]"));
    System.out.println("Schritt 7");
    System.out.println("Inhalt der Tabelle: " + TabellenEintrag.getText());
    
    //hier muss der Eintrag aus dem Feld 'Anfangskapital' übernommen werden
    //wenn die Eingabe falsch war dann wird der Eintrag beim Berechnen mit 1,00 ersetzt
    Eingabe_alsText = driver.findElement(By.xpath("//input[@name='anfangskapital']")).getText();
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
    
    
    
    }

}