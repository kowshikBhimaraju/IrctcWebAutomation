package Irctc.automation.CommonMethods;

import org.openqa.selenium.WebDriver;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class CommonMethods {
    WebDriver driver;
    public WebDriverWait webDriverWait;


    public CommonMethods(WebDriver driver) {
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
}