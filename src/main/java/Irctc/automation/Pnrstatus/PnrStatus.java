package Irctc.automation.Pnrstatus;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;


import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;

public class PnrStatus extends PnrStatusXpaths {

	public WebDriver driver;
	WebElement entryNo, enquiryTextValidation, submitButtonPnrEnquiry, captchaCodeNumeric, rtbsLink, calendarIcon,
			calendarTable, sourceStation;
	
	String pathforScreenShot = "C:\\Users\\bhavy\\eclipse-workspace\\Work\\Irctc.web\\captchaImages\\captcha.jpeg";
	ArrayList<WebElement> sourceDestinationList;
	public PnrStatus(WebDriver driver) {
		this.driver = driver;
		entryNo = driver.findElement(By.xpath(pnrNoEntry));
		submitButtonPnrEnquiry = driver.findElement(By.xpath(submitButton));
		captchaCodeNumeric = driver.findElement(By.id(captchaCodeId));
		rtbsLink = driver.findElement(By.xpath(rtbStations));
//		calendarIcon = driver.findElement(By.cssSelector(calendarRtbsImg));
//		calendarTable=driver.findElement(By.id(calendarTableId));
		sourceStation=driver.findElement(By.id(sourceStationPnrEnquiry));
		
		
	}

	public void pnrStatusWindow(String data) throws IOException {
		switch (data) {
		case "PNR Enquiry":
			entryNo.sendKeys("4910745499");
			submitButtonPnrEnquiry.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			try {
				File source = captchaCodeNumeric.getScreenshotAs(OutputType.FILE);
				FileHandler.copy(source, new File(pathforScreenShot));
				ITesseract image = new Tesseract();
				String imageOcr = image.doOCR(new File(pathforScreenShot));
				System.out.println("----------------Image ORC Conversion Done-----------------");
				System.out.println("captcha VALUE" + imageOcr);
			} catch (Exception e) {
				System.out.println("Image OCR failed " + e.getMessage());
			}
			break;
		case "Reserved Train Between Stations":
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			rtbsLink.click();
//			calendarIcon.click();
			sourceDestinationList=new ArrayList<WebElement>();
			sourceStation.sendKeys("HYD");
			break;
		case "Seat Availability":
			break;
		case "Fare Enquiry":
			break;
		case "Reserved Train Schedule":
			break;
		}

	}

}
