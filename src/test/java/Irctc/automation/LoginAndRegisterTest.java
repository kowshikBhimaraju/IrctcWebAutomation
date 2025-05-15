package Irctc.automation;

import java.io.IOException;

import Irctc.automation.Driver.DriverInitialization;
import Irctc.automation.LoginRegister.LoginRegisterMethods;
import net.sourceforge.tess4j.TesseractException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginAndRegisterTest extends DriverInitialization {

    LoginRegisterMethods loginRegisterMethods;

//    public LoginAndRegisterTest() {
//    }

    @BeforeTest
    public void setUp() throws IOException {
        browserSelection();
        loginRegisterMethods = new LoginRegisterMethods(driver);
    }

//    @AfterTest
//    public void setUpClosuer() {
//        driver.close();
//    }

    @Test
    public void loginButtonHomePage() {
        loginRegisterMethods.loginFeatureFunctionality();
    }

    @Test
    public void registerButtonLoginPage() throws TesseractException, IOException {
        loginRegisterMethods.registerButtonHomePage();
    }


}
