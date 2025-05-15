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
import org.openqa.selenium.support.ui.Select;

public class PnrStatus {

    public WebDriver driver;
    PnrStatusXpaths pnrStatusXpaths;
    String parentWindowHandleString;
    WebElement homePagePnrStatusButton, captchaCodeNumeric, calendarIcon, calendarTable, sourceStation;
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
                    System.out.println("----------------Image ORC Conversion Done-----------------");
                    System.out.println("captcha VALUE" + imageOcr);
                } catch (Exception e) {
                    System.out.println("Image OCR failed " + e.getMessage());
                }
                break;
            case "Reserved Train Between Stations":
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.findElement(By.xpath(pnrStatusXpaths.rtbStations)).click();
                driver.findElement(By.xpath(pnrStatusXpaths.calendarRtbsImg)).click();
                driver.findElement(By.xpath(pnrStatusXpaths.calenderLeftBlock)).click();
                String monthName = driver.findElement(By.xpath(pnrStatusXpaths.selectMonthName)).getText().toString();
                System.out.println("MONTH NAME:::" + monthName);
                WebElement tableBody = driver.findElement(By.xpath(pnrStatusXpaths.selectDateForFirsTable));
                List<WebElement> tableRows = tableBody.findElements(By.tagName("tr"));
                int sizeOfTableRows = tableRows.size();
                System.out.println("List of Elements for table rows" + sizeOfTableRows);
                for (WebElement tableRow : tableRows) {
                    List<WebElement> tableData = tableRow.findElements(By.tagName("td"));
                    int sizeOfTableData = tableData.size();
                    System.out.println("List of Elements for table data" + sizeOfTableData);
                }


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
