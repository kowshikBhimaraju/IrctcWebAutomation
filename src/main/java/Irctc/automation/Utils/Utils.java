package Irctc.automation.Utils;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
    WebDriver driver;
    public WebDriverWait webDriverWait;
    int targetDay, targetMonth, targetYear;


    public Utils(WebDriver driver) {
        this.driver = driver;
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
        Date formattedTargetDate;
        Calendar calendar = Calendar.getInstance();//To get the current time
        SimpleDateFormat targetDateFormat = new SimpleDateFormat(dateFormat);//To set the format as per the UI calendar
        try {
            targetDateFormat.setLenient(true);
            formattedTargetDate = targetDateFormat.parse(targetDate);
            calendar.setTime(formattedTargetDate);
            targetDay = calendar.get(Calendar.DAY_OF_MONTH);
            targetMonth = calendar.get(Calendar.MONTH);
            targetYear = calendar.get(Calendar.YEAR);

        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }
}