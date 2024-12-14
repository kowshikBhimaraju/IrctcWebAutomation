package Irctc.automation.HomePage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

import Irctc.automation.CommonMethods.CommonMethods;
import Irctc.automation.CommonUtilities.CommonUtils;
import Irctc.automation.Pnrstatus.PnrStatus;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class HomePage extends CommonMethods {
	String pathforScreenShot = "C:\\Users\\bhavy\\eclipse-workspace\\Work\\Irctc.web\\captchaImages\\captcha.png";
	WebDriver driver;
	WebElement captchaHomePage, homePagePnrStatusButton, homePageChartsAndVacancyButton, homePageFlightsHyperLink;
	CommonUtils commonUtils;
	PnrStatus pnrStatus;
	String parentWindowHandleString;
	HomePageXpaths homePageXpaths;

	public HomePage(WebDriver driver) {
		super(driver);
		System.out.println("Initializing IrctcHomePage driver" + driver);
		this.driver = driver;
		homePageXpaths = new HomePageXpaths();
	}

//	public void menuButton() {
//		homePageMenuButton = driver.findElement(By.xpath(homePageXpaths.MenuButton));
//		homePageMenuButton.click();
//
//	}

	public void loginFeatureHomePage() throws InterruptedException {
		driver.findElement(By.xpath(homePageXpaths.loginButtonXpath)).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		waitFor(2);
		try {
			driver.findElement(By.xpath(homePageXpaths.loginUserNameTextXpath)).sendKeys("ammulupr");
			driver.findElement(By.xpath(homePageXpaths.loginPasswordTextXpath)).sendKeys("7538883233Aa");
			captchaHomePage = driver.findElement(By.xpath(homePageXpaths.loginCaptchaXpath));
			File source = captchaHomePage.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(source, new File(pathforScreenShot));
			ITesseract image = new Tesseract();
			String imageOcr = image.doOCR(new File(pathforScreenShot));
			System.out.println("----------------Image ORC Conversion Done-----------------");
			System.out.println("captcha VALUE" + imageOcr);
			driver.findElement(By.id(homePageXpaths.loginCaptchaTextId)).sendKeys(imageOcr);
			driver.findElement(By.xpath(homePageXpaths.loginSignInButtonXpath)).click();
			driver.findElement(By.xpath(homePageXpaths.loginLogoutButtonXpath)).click();;
		} catch (Exception e) {
			System.out.println("Image OCR failed " + e.getMessage());
		}
	}

	public void pnrStatusButton(String data) throws IOException {
		homePagePnrStatusButton = driver.findElement(By.xpath(homePageXpaths.PnrStatusButton));
		homePagePnrStatusButton.click();
		commonUtils = new CommonUtils(driver);
		commonUtils.webDriverWait();
		parentWindowHandleString = driver.getWindowHandle();
		System.out.println(parentWindowHandleString);
		for (String windowHandle : driver.getWindowHandles()) {
			if (!parentWindowHandleString.contentEquals(windowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		pnrStatus = new PnrStatus(driver);
		pnrStatus.pnrStatusWindow(data);
	}

	public void chartsAndVacancyButton() {
		homePageChartsAndVacancyButton = driver.findElement(By.xpath(homePageXpaths.ChartsAndVacancyButton));
		homePageChartsAndVacancyButton.click();
	}

	public void flightsHyperLink() {
		homePageFlightsHyperLink = driver.findElement(By.xpath(homePageXpaths.flightsHyperLink));
		homePageFlightsHyperLink.click();
	}

}
