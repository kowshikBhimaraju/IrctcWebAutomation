package Irctc.automation.PnrStatus;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import Irctc.automation.HomePage.HomePage;
import Irctc.automation.Pnrstatus.PnrStatus;

public class PnrStatuTest {
    public WebDriver driver;
    HomePage HomePage;

    PnrStatus pnrStatus;
   
    
    @Test
    public void pnrEnquiryTest() throws IOException {
//        browserSelection();
        HomePage = new HomePage(driver);
        HomePage.pnrStatusButton("Reserved Train Between Stations");
//        driver.quit();
    }
}
