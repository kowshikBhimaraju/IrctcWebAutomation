package Irctc.automation;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Irctc.automation.BookTicket.BookTicketMethods;
import Irctc.automation.Driver.DriverInitialization;

public class BookTicketTest extends DriverInitialization {

    BookTicketMethods bookTicketMethods;

//    public BookTicketTest() {
//
//    }


    @BeforeTest
    public void setUp() throws IOException {
        browserSelection();
        bookTicketMethods = new BookTicketMethods(driver);
    }


     @AfterTest
    public void tearDown() {
        driver.close();
    }

   

    @Test
    public void bookTicket() throws InterruptedException {
        bookTicketMethods.bookTicket();
    }
}
