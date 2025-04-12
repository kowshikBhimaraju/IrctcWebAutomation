package Irctc.automation.HomePage;

import java.io.IOException;

import Irctc.automation.Driver.DriverInitialization;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginAndRegisterTest extends DriverInitialization {

    LoginRegisterMethods homePageMethods;

    public LoginAndRegisterTest() {
    }

    @BeforeTest
    public void setUp() throws IOException {
        browserSelection();
        homePageMethods = new LoginRegisterMethods(driver);
    }

    @AfterTest
    public void setUpClosuer() {
        driver.close();
    }

    @Test
    public void loginButtonHomePage() {
        homePageMethods.loginFeatureHomePage();
    }

    @Test
    public void registerButtonLoginPage() throws TesseractException, IOException {
        homePageMethods.registerButtonHomePage();
    }


}
