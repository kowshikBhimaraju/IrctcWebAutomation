package Irctc.automation;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

import Irctc.automation.CommonMethods.CommonMethods;
import Irctc.automation.Pnrstatus.PnrStatus;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class LoginRegisterMethods {
    final String errorMessageInvalidCredentials = "Incorrect User Name / Password. You are left with 4 more attempts.";
    String pathforScreenShot = "C:\\Users\\2159800\\Uiscreenshots\\captcha.png";
    WebDriver driver;
    WebElement captchaHomePage, captchaRegisterButton, homePageChartsAndVacancyButton, homePageFlightsHyperLink;
    PnrStatus pnrStatus;
    String errorMessageForInvalidCredentials;
    LoginRegisterXpaths loginRegisterXpaths;


    public LoginRegisterMethods(WebDriver driver) {
        System.out.println("Initializing IrctcHomePage driver" + driver);
        this.driver = driver;
        loginRegisterXpaths = new LoginRegisterXpaths();
    }

    /*public void menuButton() {
        homePageMenuButton = driver.findElement(By.xpath(loginRegisterXpaths.MenuButton));
        homePageMenuButton.click();

    }
*/

    public void loginFeatureHomePage() {
        driver.findElement(By.xpath(loginRegisterXpaths.MenuButton)).click();
        driver.findElement(By.xpath(loginRegisterXpaths.loginButtonXpathTwo)).click();
    }

    public void loginFeatureFunctionality() {
        loginFeatureHomePage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CommonMethods.waitFor(2);
        try {
            driver.findElement(By.xpath(loginRegisterXpaths.loginUserNameTextXpath)).sendKeys("ammulupr");
            driver.findElement(By.xpath(loginRegisterXpaths.loginPasswordTextXpath)).sendKeys("753888333Aa");
            captchaHomePage = driver.findElement(By.xpath(loginRegisterXpaths.loginCaptchaXpath));
            File source = captchaHomePage.getScreenshotAs(OutputType.FILE);
            FileHandler.copy(source, new File(pathforScreenShot));
            ITesseract image = new Tesseract();
            String imageOcr = image.doOCR(new File(pathforScreenShot));
            System.out.println("----------------Image ORC Conversion Done-----------------");
            System.out.println("captcha VALUE" + imageOcr);
            driver.findElement(By.id(loginRegisterXpaths.loginCaptchaTextId)).sendKeys(imageOcr);
            WebElement loginSingUpButton = driver.findElement(By.xpath(loginRegisterXpaths.loginSignInButtonXpath));
            loginSingUpButton.click();
            errorMessageForInvalidCredentials = driver.findElement(By.cssSelector(loginRegisterXpaths.errorMessageCssSelector)).getText();
            assertEquals(errorMessageForInvalidCredentials, errorMessageInvalidCredentials, "Invalid Credentials Validated");
//            waitFor(2);
//            driver.findElement(By.xpath(loginRegisterXpaths.loginLogoutButtonXpath)).click();
        } catch (Exception e) {
            System.out.println("Image OCR failed " + e.getMessage());
        }
    }

    public void registerButtonHomePage() throws IOException, TesseractException {
        driver.findElement(By.xpath(loginRegisterXpaths.MenuButton)).click();
        driver.findElement(By.xpath(loginRegisterXpaths.loginButtonXpathTwo)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath(loginRegisterXpaths.registerButton)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        CommonMethods.waitFor(2);
        driver.findElement(By.cssSelector(loginRegisterXpaths.userNameRegisterCssSelector)).sendKeys("testingSelenium");
        driver.findElement(By.cssSelector(loginRegisterXpaths.fullNameRegisterCssSelector)).sendKeys("SeleniumTester");
        driver.findElement(By.cssSelector(loginRegisterXpaths.passwordRegisterCssSelector)).sendKeys("Selenium@123");
        driver.findElement(By.cssSelector(loginRegisterXpaths.confirmPasswordRegisterCssSelector)).sendKeys("Selenium@123");
        driver.findElement(By.cssSelector(loginRegisterXpaths.emailRegisterCssSelector)).sendKeys("selenium123@gmail.com");
        driver.findElement(By.cssSelector(loginRegisterXpaths.mobileNumberRegisterCssSelector)).sendKeys(CommonMethods.randomTenDigit());
        captchaRegisterButton = driver.findElement(By.xpath(loginRegisterXpaths.captchaRegisterButtonXpath));
        File source = captchaRegisterButton.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(source, new File(pathforScreenShot));
        ITesseract image = new Tesseract();
        String imageOcr = image.doOCR(new File(pathforScreenShot));
        System.out.println("----------------Image ORC Conversion Done-----------------");
        System.out.println("captcha VALUE" + imageOcr);
        driver.findElement(By.cssSelector(loginRegisterXpaths.captchaRegisterTextCssSelector)).sendKeys(imageOcr);
        driver.findElement(By.xpath(loginRegisterXpaths.okButtonPopUpRegisterXpath)).click();
        WebElement otpValidationValue = driver.findElement(By.xpath(loginRegisterXpaths.otpAssertionStringValueXpath));
        String otpAssertion = otpValidationValue.getText();
        assertEquals(otpAssertion, "Please enter OTP received on provided Mobile number and Email ID");

    }


    public void chartsAndVacancyButton() {
        homePageChartsAndVacancyButton = driver.findElement(By.xpath(loginRegisterXpaths.ChartsAndVacancyButton));
        homePageChartsAndVacancyButton.click();
    }

    public void flightsHyperLink() {
        homePageFlightsHyperLink = driver.findElement(By.xpath(loginRegisterXpaths.flightsHyperLink));
        homePageFlightsHyperLink.click();
    }

}
