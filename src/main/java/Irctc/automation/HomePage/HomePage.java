package Irctc.automation.HomePage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import Irctc.automation.CommonMethods.CommonMethods;
import Irctc.automation.CommonUtilities.CommonUtils;
import Irctc.automation.Pnrstatus.PnrStatus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	WebDriver driver;
	WebElement loginButton, homePageMenuButton, homePagePnrStatusButton, homePageChartsAndVacancyButton,
			homePageFlightsHyperLink;
	CommonUtils commonUtils;
	PnrStatus pnrStatus;
	String parentWindowHandleString;
	HomePageXpaths homePageXpaths;

	public HomePage(WebDriver driver) {
		System.out.println("Initializing IrctcHomePage driver" + driver);
		this.driver = driver;
		homePageXpaths = new HomePageXpaths();
	}

//	public void menuButton() {
//		homePageMenuButton = driver.findElement(By.xpath(homePageXpaths.MenuButton));
//		homePageMenuButton.click();
//
//	}

	public void loginFeatureHomePage() {
		loginButton = driver.findElement(By.xpath(homePageXpaths.loginButtonXpath));
		loginButton.click();
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
