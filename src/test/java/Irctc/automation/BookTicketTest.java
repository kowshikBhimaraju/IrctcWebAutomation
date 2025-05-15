package Irctc.automation;

import Irctc.automation.BookTicket.BookTicketMethods;
import Irctc.automation.Driver.DriverInitialization;
import Irctc.automation.LoginRegister.LoginRegisterMethods;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

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

    @Test
    public void bookTicket() throws InterruptedException {
        bookTicketMethods.bookTicket();
    }
}
