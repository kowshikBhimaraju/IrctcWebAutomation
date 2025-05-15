package Irctc.automation;

import java.io.IOException;

import Irctc.automation.Driver.DriverInitialization;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Irctc.automation.Pnrstatus.PnrStatus;

public class PnrStatuTest extends DriverInitialization {

    PnrStatus pnrStatus;

    @BeforeTest
    public void setUp() throws IOException {
        browserSelection();
        pnrStatus = new PnrStatus(driver);
    }

    @AfterTest
    public void setUpClosuer() throws InterruptedException {
        Thread.sleep(10000);
        driver.close();
//        Thread.sleep(5000);
//        driver.quit();
    }

    @Test
    public void pnrEnquiryTest() throws IOException {
        pnrStatus.pnrStatusButton("Reserved Train Between Stations");
    }
}
