package de.people.selenium.webdriver.basic;

import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ZinsenRechner_Testfall1 {
	
	
	public void Testfall1_defaultEinstellungen(WebDriver driver, Properties prop){
		
		String myURL = prop.getProperty("url");
		
	System.out.println("Schritt 1 und die URL: " +myURL);	
	driver.get(myURL);
	System.out.println("Schritt 2");
    driver.findElement(By.xpath("//input[@name='anfangskapital']")).clear();
    System.out.println("Schritt 3");
    driver.findElement(By.xpath("//input[@name='anfangskapital']")).sendKeys("6543");
    System.out.println("Schritt 4");
    driver.findElement(By.name("berechnen")).click();
    System.out.println("Schritt 4");

    }

}