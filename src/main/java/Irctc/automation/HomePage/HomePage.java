package Irctc.automation.HomePage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import Irctc.automation.CommonUtilities.CommonUtils;
import Irctc.automation.Pnrstatus.PnrStatus;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends HomePageXpaths {
	public WebDriver driver;
	WebElement homePageMenuButton, homePagePnrStatusButton, homePageChartsAndVacancyButton, homePageFlightsHyperLink;
	CommonUtils commonUtils;
	PnrStatus pnrStatus;
	String parentWindowHandleString;

	public HomePage(WebDriver driver) {
		System.out.println("Initializing IrctcHomePage driver" + driver);
		this.driver = driver;
		homePageMenuButton = driver.findElement(By.xpath(MenuButton));
		homePagePnrStatusButton = driver.findElement(By.xpath(PnrStatusButton));
		homePageChartsAndVacancyButton = driver.findElement(By.xpath(ChartsAndVacancyButton));
		homePageFlightsHyperLink = driver.findElement(By.xpath(flightsHyperLink));
		parentWindowHandleString = driver.getWindowHandle();
	}

	public void menuButton() {
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
		javaScriptExecutor.executeScript("document.body.style.zoom='125%'");
		homePageMenuButton.click();

	}

	public void pnrStatusButton(String data) throws IOException {
		homePagePnrStatusButton.click();
		commonUtils = new CommonUtils(driver);
		commonUtils.webDriverWait();
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
		homePageChartsAndVacancyButton.click();
	}

	public void flightsHyperLink() {
		homePageFlightsHyperLink.click();
	}

}
