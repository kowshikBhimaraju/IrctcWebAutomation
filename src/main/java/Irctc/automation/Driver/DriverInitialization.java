package Irctc.automation.Driver;

import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class DriverInitialization {
    /*DriverInitialization is parent class where this will be inherited by the child classes or all TEST classes*/

    public String path = "C:\\IrctcWebAutomation\\DataProvider.properties";
    public static WebDriver driver;


    public void browserSelection() throws IOException {
        Properties prop = new Properties();
        FileReader fileReader = new FileReader(path);
        prop.load(fileReader);
        String browser = prop.getProperty("browser");
        String url = prop.getProperty("URL");
        if (browser.equals("Chrome")) {
            driver = new ChromeDriver();
            driver.get(url);
            driver.manage().window().maximize();
        } else if (browser.equals("Edge")) {
            driver = new EdgeDriver();
            driver.get(url);
            driver.manage().window().maximize();
        } else if (browser.equals("FirefoxDriver")) {
            driver = new FirefoxDriver();
            driver.get(url);
            driver.manage().window().maximize();
        } else {
            System.out.println("No WebDriver Found, Hence ending the TestRun!!!!!");
        }
    }
}
