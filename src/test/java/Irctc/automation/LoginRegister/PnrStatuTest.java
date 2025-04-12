package Irctc.automation.HomePage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Irctc.automation.Pnrstatus.PnrStatus;

public class PnrStatuTest {
    public WebDriver driver;
    LoginRegisterMethods homePageMethods;

    PnrStatus pnrStatus;
   
    
    @Test
    public void pnrEnquiryTest() throws IOException {
//        browserSelection();
        homePageMethods = new LoginRegisterMethods(driver);
        homePageMethods.pnrStatusButton("Reserved Train Between Stations");
//        driver.quit();
    }
}
