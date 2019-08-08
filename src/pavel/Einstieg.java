package pavel;

import org.openqa.selenium.WebDriver;

//import pavel.Testklasse1;
import pavel.handleBrowser;
import pavel.handleProperties;

public class Einstieg {

	static String projectLocation, browser, chromeDriverLocation,
    firefoxDriverLocation, baseUrl;
static handleProperties hdlProps;
static handleBrowser hdlBrowser;
static WebDriver testDriver;
//static Testklasse1 test1;


public static void main(String[] args) {

System.out.println("Start.");

//  data.properties lesen
hdlProps = new handleProperties();
projectLocation = hdlProps.getProjectLog();
hdlProps.getProperties(projectLocation);

//  Browser mit Treiber initialisieren
browser = hdlProps.getBrowser();
chromeDriverLocation = hdlProps.getChromeDriverLocation();
firefoxDriverLocation =  hdlProps.getFirefoxDriverLocation();
baseUrl = hdlProps.getUrl();
hdlBrowser = new handleBrowser(browser, firefoxDriverLocation, chromeDriverLocation);

//  Testklasse 1 aufrufen
testDriver = hdlBrowser.getDriver();
test1 = new Testklasse1(testDriver, hdlProps);


}
}