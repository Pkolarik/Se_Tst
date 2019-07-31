package de.people.selenium.webdriver.basic;

import java.math.BigDecimal;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ZinsenRechner_Testfall1 {
	
	
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
    driver.findElement(By.xpath("//input[@name='anfangskapital']")).clear();
    System.out.println("Schritt 3");
    driver.findElement(By.xpath("//input[@name='anfangskapital']")).sendKeys(Eingabe_alsText);
    System.out.println("Schritt 4");
    driver.findElement(By.name("berechnen")).click();
    System.out.println("Schritt 4");
    
    WebElement TabellenEintrag = driver.findElement(By.xpath("//table[@class='verlauf']/tbody/tr[2]/td[2]"));
    System.out.println("Schritt 5");
    System.out.println("Inhalt der Tabelle: " + TabellenEintrag.getText());
    
    Eingabe_alsText2 = Eingabe_alsText.replace(".", "");
    Eingabe_alsText2 = Eingabe_alsText2.replace(",", ".");
    System.out.println("Eingabe als Text konvertiert " + Eingabe_alsText2);
    Eingabe = Double.parseDouble(Eingabe_alsText2);
    
    Ausgabe_alsText = TabellenEintrag.getText();
    Ausgabe_alsText2 = Ausgabe_alsText.replace(".", "");
    Ausgabe_alsText2 = Ausgabe_alsText2.replace(",", ".");
    System.out.println("Eingabe als Text konvertiert " + Ausgabe_alsText2);
    Ausgabe = Double.parseDouble(Ausgabe_alsText2);
   
    System.out.println("Schritt 6");
    Vergleich = Double.compare(Eingabe, Ausgabe);
    System.out.println("Schritt 7");
    
    if (Vergleich == 0)
        System.out.println("Eingabe und Ausgabe sind gleich \n");
    else
    	System.out.println("Eingabe und Ausgabe sind nichts gleich \n");
    
    
    
    }

}