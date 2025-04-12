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

public class PnrStatus {

    public WebDriver driver;
    PnrStatusXpaths pnrStatusXpaths;
    String parentWindowHandleString;
    WebElement homePagePnrStatusButton, captchaCodeNumeric, rtbsLink, calendarIcon, calendarTable, sourceStation;
    String pathforScreenShot = "C:\\Users\\2159800\\Uiscreenshots\\captcha.png";
    ArrayList<WebElement> sourceDestinationList;

    public PnrStatus(WebDriver driver) {
        System.out.println("Initializing IrctcHomePage driver" + driver);
        this.driver = driver;
        pnrStatusXpaths = new PnrStatusXpaths();
    }

    public void pnrStatusButton(String data) throws IOException {
        homePagePnrStatusButton = driver.findElement(By.xpath(pnrStatusXpaths.PnrStatusButton));
        homePagePnrStatusButton.click();
        parentWindowHandleString = driver.getWindowHandle();
        System.out.println(parentWindowHandleString);
        for (String windowHandle : driver.getWindowHandles()) {
            if (!parentWindowHandleString.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        pnrStatusWindow(data);
    }


    public void pnrStatusWindow(String data) throws IOException {
        switch (data) {
            case "PNR Enquiry":
                driver.findElement(By.xpath(pnrStatusXpaths.pnrNoEntry)).sendKeys("4910745499");
                driver.findElement(By.xpath(pnrStatusXpaths.submitButton)).click();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                try {
                    captchaCodeNumeric = driver.findElement(By.id(pnrStatusXpaths.captchaCodeId));
                    File source = captchaCodeNumeric.getScreenshotAs(OutputType.FILE);
                    FileHandler.copy(source, new File(pathforScreenShot));
                    ITesseract image = new Tesseract();
                    String imageOcr = image.doOCR(new File(pathforScreenShot));
                    imageOcr.substring(0, 4);
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
                sourceDestinationList = new ArrayList<WebElement>();
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
