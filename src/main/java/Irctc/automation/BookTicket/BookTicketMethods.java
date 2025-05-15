package Irctc.automation.BookTicket;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BookTicketMethods {

    WebDriver driver;
    BookTicketXpaths bookTicketXpaths;

    public BookTicketMethods(WebDriver driver) {
        System.out.println("Initializing IrctcHomePage driver" + driver);
        this.driver = driver;
        bookTicketXpaths = new BookTicketXpaths();
    }


    public void bookTicket() {
        driver.findElement(By.xpath(bookTicketXpaths.fromAutoSuggestiveDropDown)).sendKeys("Hy");
        List<WebElement> fromSearchAutoSuggestionList = driver.findElements(By.xpath(bookTicketXpaths.fromAutoSuggestionInputXpath));
        for (WebElement searchFromStationList : fromSearchAutoSuggestionList) {
            if (searchFromStationList.getText().equalsIgnoreCase(" HYDERABAD DECAN - HYB ")) {
                searchFromStationList.click();
            }
            System.out.println("LIST OF STATIONS FROM THE GIVEN INPUT" + searchFromStationList);
            break;
        }
    }
}
