package de.people.selenium.webdriver.basic;

import java.math.BigDecimal;

public class TestZinsenrechner_KPA_tutorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int var1 = 5;
		int var2 = 2;
		int var3 = var1/var2; //Ergebnis int int
		
		/* int hat ein Max und Min von  -2hoch32 bis (2hoch32-1)
		wenn man eine größer Zahl braucht muss man float nehmen
		*/
		
		double var4 = 5.0;
		double var5 = 2;
		//Casten
		int intAusdouble = (int) var4; //double in int umwandeln
		
		
		String Eingabe_alsText = "3456,50";
		Eingabe_alsText.replace(",", ".");
	

		 
		
		BigDecimal Eingabe= new BigDecimal(Eingabe_alsText);
		
		
		System.out.println("Meine Eingabe ist: " + Eingabe.toPlainString());
		
		
		
		
		/*
		double var6 = var4/var5;
		double var7 = var1/var2; //= 2.0 hier werden zwei int geteilt, Ergebnis ist double
		System.out.println(var3);
		System.out.println(var6);
		System.out.println(var7);
		System.out.println(intAusdouble);
		
        // int durch double teilen: double wird ausgegeben
		// double durch int teilen: Fehler geht nicht 
		 
		 */
	}

}
