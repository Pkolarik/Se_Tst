package de.people.selenium.webdriver.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Zinsenrechner_Testfall4 {

	/*
	 * in der Klasse erfolgt ein Zugriff auf eine lokale MS Access DB. In einem
	 * E2E (Web-Sete -> DB) Test könnte dann die Eingabe auf der WebSeite mit
	 * dem Ergebnis in einer DB verglichen werden
	 */

	void Testfall4_Read_DB(WebDriver driver, Properties prop) {

		String url = "jdbc:ucanaccess://" + System.getProperty("user.dir") + "\\Database1.accdb";
		System.out.println("die URL ist: " + url);
		Connection con;
		Statement stmt;
		String query = "Select * from Tabelle1";
		System.out.println("1a");
		try {
			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			System.out.println("1b");
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			System.out.println("2");
			con = DriverManager.getConnection(url, "", "");
			stmt = con.createStatement();
			System.out.println("3");
			ResultSet rs = stmt.executeQuery(query);

			while (rs.next()) {
				System.out.println("4");
				String dbEintrag = rs.getString("Zinsenberechnung");
				System.out.println("Eintrag in der DB: " + dbEintrag);
			}
			System.out.println("5");
			stmt.close();

			con.close();
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
