package config;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFile {
	
	public static void main(String[] args) {
		readPropertiesFile();
	}

	public static void readPropertiesFile(){
		Properties prop = new Properties();
		try {
			InputStream input = new FileInputStream("C:\\Program Files\\eclipse\\workspace\\Se_Tst\\src\\config\\config.properties");
			prop.load(input);
			System.out.println(prop.getProperty("browser"));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
}
