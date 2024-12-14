package Irctc.automation.HomePage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Irctc.automation.CommonMethods.CommonMethods;

public class HomePageTest extends CommonMethods {
   
	private static WebDriver driver;
    HomePage HomePage;
    
    public HomePageTest() {
    	super(driver);
    }
 
    @Test
    public synchronized void navigateToIrctcHomePage() throws IOException {
        browserSelection();
        HomePage = new HomePage(driver);
        HomePage.menuButton();
//        driver.quit();
    }

    @Test
    public synchronized void navigateToPnrStatus() throws IOException, InterruptedException {
        browserSelection();
        HomePage.pnrStatusButton("PNR Enquiry");
//        driver.quit();
    }

    @Test
    public void navigateToChartsAndVacancy() throws IOException {
        browserSelection();
        HomePage.chartsAndVacancyButton();
//        driver.quit();
    }

    @Test
    public void navigateToFlightsPage() throws IOException {
        browserSelection();
        HomePage.flightsHyperLink();
    }

}
