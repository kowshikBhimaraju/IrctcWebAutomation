package Irctc.automation.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Irctc.automation.BookTicket.BookTicketXpaths;

public class Utils {
    WebDriver driver;
    BookTicketXpaths bookTicketXpaths;
    public WebDriverWait webDriverWait;
    int targetDay, targetMonth, targetYear;


    public Utils(WebDriver driver) {
        this.driver = driver;
        bookTicketXpaths = new BookTicketXpaths();
    }

    public static void waitFor(int Count) {
        for (int i = 0; i <= Count; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static String randomTenDigit() {
        long randomNumber = (long) (Math.random() * 100000 * 10000);
        String concatinatedNumber = "7" + randomNumber;
        return concatinatedNumber;
    }

    public void setCalendarDate(String targetDate, String dateFormat) {
        System.out.println("Target Date: " + targetDate);   
        Date formattedTargetDate;
        Calendar calendar = Calendar.getInstance();//To get the current time
        System.out.println("Current Date: " + calendar.getTime());
        SimpleDateFormat targetDateFormat = new SimpleDateFormat(dateFormat);
        System.out.println("targetDateFormat" +targetDateFormat);;//To set the format as per the UI calendar
        try {
            targetDateFormat.setLenient(true);
            formattedTargetDate = targetDateFormat.parse(targetDate);
            calendar.setTime(formattedTargetDate);
            System.out.println("Formatted Target Date: " + formattedTargetDate);
            targetDay = calendar.get(Calendar.DAY_OF_MONTH);
            System.out.println("Target Day: " + targetDay);
            targetMonth = calendar.get(Calendar.MONTH);
            targetYear = calendar.get(Calendar.YEAR);

            driver.findElement(By.cssSelector(bookTicketXpaths.calendarInput)).click();
            driver.findElement(By.xpath(bookTicketXpaths.toSelectDateXpath(targetDay))).click();

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}