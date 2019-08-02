package de.people.selenium.webdriver.basic;

import org.openqa.selenium.WebDriver;

public class TestZinsenrechner_Ausstieg {
	
	void tearDown (WebDriver driver) {
		
      try{

	    Thread.sleep(30000); //warte 30 Sekungen
	    driver.close();
	    System.out.println("Driver beenden");

	  } catch(Exception e){

	     System.out.print(e);
	     System.out.println("Driver beenden mit Exception");

	    }
      
	}
	   
	          

}
