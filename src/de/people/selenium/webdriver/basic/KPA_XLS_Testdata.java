package de.people.selenium.webdriver.basic;

import java.io.BufferedReader;
import java.io.FileReader;


public class KPA_XLS_Testdata {
	private static final String COLUMN_DELIMITER = ";";

	/*
	 * !!!!!!!!!!!ACHTUNG !!!!!!!!!!!!!!! Es wird nicht als xls sondern aus csv
	 * gelesen Ich habe aber die Klasse nicht umbenannt Diese Klasse
	 * representiert unsere Testdatan einem csv file
	 * 
	 */

	KPA_XLS_Testdata() {
	}

	String getXLSfile(String testdaten_pfad) {
		String Eintrag = "";


		try {

			// FileInputStream file = new FileInputStream(new
			// File(testdaten_pfad));
			System.out.println("Pfad ist: " + testdaten_pfad);
			final BufferedReader br = new BufferedReader(new FileReader(testdaten_pfad));
			String line = null;
			System.out.println("Vor der Schleife");
			// Lesen in der DAtei alle Zeilen nacheinander
			while ((line = br.readLine()) != null) {

				final String[] lineValues = line.split(COLUMN_DELIMITER);
				// pro Zeile - nacheinder alle Einträge aus der Zeile lesen
				for (String lineValue : lineValues) {
					System.out.println("Eintrag in csv ist: " + lineValue);
					Eintrag = lineValue;

				}


			}
			br.close();
			System.out.println("Nach der Schleife");

			return Eintrag;
		} catch (Exception e) {
			System.out.print(e);
			return "Fehler123";
		}
	}

}
