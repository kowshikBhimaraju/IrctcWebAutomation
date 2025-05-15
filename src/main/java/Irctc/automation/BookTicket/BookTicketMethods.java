package Irctc.automation.BookTicket;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BookTicketMethods {

    WebDriver driver;
    BookTicketXpaths bookTicketXpaths;

    public BookTicketMethods(WebDriver driver) {
        System.out.println("Initializing IrctcHomePage driver" + driver);
        this.driver = driver;
        bookTicketXpaths = new BookTicketXpaths();
    }


    public void bookTicket() throws InterruptedException {
//        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement fromInput = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(bookTicketXpaths.fromAutoSuggestiveDropDown)));
//        fromInput.click();
//        fromInput.sendKeys("HY");
//
//        // Wait for suggestions to appear
//        List<WebElement> suggestions = webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(bookTicketXpaths.css)));
//
//// Iterate and select the first valid station (skip "Stations" label)
//        for (WebElement suggestion : suggestions) {
//            String text = suggestion.getText().trim();
//            if (!text.equalsIgnoreCase("Stations") && !text.isEmpty()) {
//                suggestion.click();
//                break;
//            }
//        }
        Thread.sleep(10000);
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        driver.findElement(By.xpath(bookTicketXpaths.fromAutoSuggestiveDropDown)).sendKeys("DELHI - DLI");
        Thread.sleep(30000);
        List<WebElement> fromSearchAutoSuggestionList = driver.findElements(By.cssSelector(bookTicketXpaths.fromAutoSuggestionInputXpath));
        for (WebElement searchFromStationList : fromSearchAutoSuggestionList) {
            String fromName = searchFromStationList.getText().toString();
            if (fromName.trim().contains("  DELHI - DLI  ")) {
                searchFromStationList.sendKeys(Keys.ARROW_DOWN);
                searchFromStationList.sendKeys(Keys.ENTER);
                break;
            }

            System.out.println("LIST OF STATIONS FROM THE GIVEN INPUT" + fromName);
        }
    }
}
