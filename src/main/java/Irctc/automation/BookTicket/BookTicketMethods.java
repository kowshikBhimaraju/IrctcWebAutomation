package Irctc.automation.BookTicket;

import Irctc.automation.Utils.Utils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;


public class BookTicketMethods {

    WebDriver driver;
    BookTicketXpaths bookTicketXpaths;
    Utils utils;
    WebElement inputFromElement, inputToElement, jounreyDate, jounreyQuota;
    WebDriverWait webDriverWait;

    public BookTicketMethods(WebDriver driver) {
        System.out.println("Initializing IrctcHomePage driver" + driver);
        this.driver = driver;
        bookTicketXpaths = new BookTicketXpaths();
    }


    public void bookTicket() throws InterruptedException {
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        try {
            webDriverWait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (TimeoutException e) {
            System.out.println("No alert present.");
        }
        inputFromElement = driver.findElement(By.cssSelector((bookTicketXpaths.fromAutoSuggestiveDropDownInput)));
        inputFromElement.clear();
        inputFromElement.sendKeys("DELHI - DLI");
//        Thread.sleep(30000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(bookTicketXpaths.fromDropDownSuggestions)));
        List<WebElement> fromSearchAutoSuggestionList = driver.findElements(By.cssSelector(bookTicketXpaths.fromDropDownSuggestions));
        for (WebElement searchFromStationList : fromSearchAutoSuggestionList) {
            if (searchFromStationList.getText().trim().contains("DELHI - DLI")) {
                webDriverWait.until(ExpectedConditions.elementToBeClickable(searchFromStationList)).click();
                searchFromStationList.click();
                break;
            }
        }

        inputToElement = driver.findElement(By.cssSelector(bookTicketXpaths.toAutoSuggestiveDropDownInput));
        inputToElement.clear();
        inputToElement.sendKeys("TIRUPATI");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(bookTicketXpaths.toDropDownSuggestions)));
        List<WebElement> toSearchAutoSuggestionList = driver.findElements(By.cssSelector(bookTicketXpaths.toDropDownSuggestions));
        for (WebElement searchToStationList : toSearchAutoSuggestionList) {
            if (searchToStationList.getText().trim().contains("TIRUPATI - TPTY")) {
                webDriverWait.until(ExpectedConditions.elementToBeClickable(searchToStationList)).click();
                searchToStationList.click();
                break;
            }
        }

        utils = new Utils(driver);
        jounreyDate = driver.findElement(By.xpath(bookTicketXpaths.calendarInput));
        utils.setCalendarDate("29/05/2025", "DD/MM/YYYY");


    }
}
