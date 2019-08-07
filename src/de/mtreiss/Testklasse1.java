package de.mtreiss;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

//import com.sun.corba.se.spi.orbutil.fsm.Input;

import org.openqa.selenium.By;

public class Testklasse1 {
	
	WebElement  eingWert, zinsZno, monWert, btn_rechnen, tabEintr,
	            TabellenEintrag;
	String      TabellenEintrag_str,
				Eingabe_alsText,
				Ausgabe_alsText,
				Ausgabe_alsText2;
	String      Eingabe_alsText2 = "3.456,51";
	Double	    Eingabe, Ausgabe, Vergleich;
	
	
	Testklasse1 (WebDriver testDriver, handleProperties props) {
		werteEingeben(testDriver, props);
		berechnungStarten(testDriver);
		ergebnisAuswerten(testDriver);
	}
	
	public void werteEingeben(WebDriver testDriver, handleProperties props) {
		testDriver.get(props.getUrl());
		System.out.println("Browser ist aufgerufen.");
		
		// Gefundener Anfangswert
	/*	ausgWert = testDriver.findElement(By.xpath("//input[@name='anfangskapital']"));
	 *  das X-PATH funktioniert nicht, unteres funktioniert, Quelle:
	 *  https://vaadin.com/forum/thread/3803119/get-value-from-textfield-textarea-using-selenium
	 */
		eingWert = testDriver.findElement(By.name("anfangskapital"));
		Eingabe_alsText = eingWert.getAttribute("value");
		System.out.println("Ursprungswert: "+ Eingabe_alsText);
		
		// Setze Anfangskapital
		eingWert.clear();
		eingWert.sendKeys(Eingabe_alsText2);
		Eingabe_alsText2 = eingWert.getAttribute("value");
		System.out.println("Eingabewert: "+ Eingabe_alsText2);
		
		// Setzte Zinseszins = Nein
		zinsZno = testDriver.findElement(By.cssSelector("input[value='nein']"));
		zinsZno.click();
		System.out.println("Zinseszins NEIN ist ausgewählt");
		
		// Setze Monatswert = "Jahre"
		monWert = testDriver.findElement(By.name("laufzeiteinheit"));
		Select selectEinheit = new Select(monWert);
		selectEinheit.selectByVisibleText("Jahre");
		
		// Temporär: Rumspielen mit Jahren
		try {Thread.sleep(2000);} 
		catch (InterruptedException e) {e.printStackTrace();}
		selectEinheit.selectByVisibleText("Monate");
		try {Thread.sleep(2000);} 
		catch (InterruptedException e) {e.printStackTrace();}
		selectEinheit.selectByVisibleText("Jahre");
	}
	
	public void berechnungStarten(WebDriver testDriver) {
	    btn_rechnen = testDriver.findElement(By.name("berechnen"));
	    btn_rechnen.click();  
	}
	
	
	public void ergebnisAuswerten(WebDriver testDriver) {
		System.out.println("------------------------");
		System.out.println("Auswertung startet.");
		System.out.println("------------------------");
		TabellenEintrag = testDriver.findElement(By.xpath("//table[@class='verlauf']/tbody/tr[2]/td[2]"));
		TabellenEintrag_str = new String(TabellenEintrag.getText());
		System.out.println("Inhalt der Tabelle: " + TabellenEintrag_str);
		    
		    //hier muss der Eintrag aus dem Feld 'Anfangskapital' übernommen werden
		    //wenn die Eingabe falsch war dann wird der Eintrag beim Berechnen mit 1,00 ersetzt
		    //Eingabe_alsText = driver.findElement(By.xpath("//input[@name='anfangskapital']")).getText();
		    // 1000.00 in 1000,00 umwandeln
		//    Duoble-Umsetzung funktioniert mit unterem Code    
		//    Eingabe_alsText2 = Eingabe_alsText.replace(".", "");
		//    Eingabe_alsText2 = Eingabe_alsText2.replace(",", ".");
		//    Eingabe = Double.parseDouble(Eingabe_alsText2);
		//    Eingabe = Integer.parseInt(Eingabe_alsText2);
			 NumberFormat myNF = NumberFormat.getInstance(Locale.GERMAN);
		      try {
		              Number number = myNF.parse(Eingabe_alsText2);
		              double Eingabe = number.doubleValue();
		              System.out.println(Eingabe);
		      } catch(ParseException ex) {
		              System.err.println("Parse exception: " + ex.getMessage());
		      }
		 //     System.out.println("Eingabe als Text konvertiert " + Eingabe);
		 //   Ausgabe_alsText = TabellenEintrag.getText();
		 //   Ausgabe_alsText2 = Ausgabe_alsText.replace(".", "");
		 //   Ausgabe_alsText2 = Ausgabe_alsText2.replace(",", ".");
		 //   System.out.println("Ausgabe als Text konvertiert " + Ausgabe_alsText2)
		 //   Ausgabe = Integer.parseInt(Ausgabe_alsText2);
	       
		      NumberFormat myNF_ausg = NumberFormat.getInstance(Locale.GERMAN);
		      try {
		              Number number_ausg = myNF.parse(Eingabe_alsText2);
		              double Ausgabe = number_ausg.doubleValue();
		              System.out.println(Ausgabe);
		      } catch(ParseException ex) {
		              System.err.println("Parse exception: " + ex.getMessage());
		      }
		      
		    System.out.println("Schritt 8");
		  //*Vergleich = Double.compare(Eingabe, Ausgabe);
		  
		    System.out.println("Schritt 9");
		    //if (Vergleich == 0)
		    if (Eingabe == Ausgabe)
		        System.out.println("Eingabe und Ausgabe sind gleich \n");
		    else
		    	System.out.println("Eingabe und Ausgabe sind nichts gleich \n");
			}
	}

