package Irctc.automation.HomePage;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HomePageTest  {
  
	public String path = "C:\\Users\\bhavy\\eclipse-workspace\\Work\\Irctc.web\\DataProvider.properties";
	public static WebDriver driver;
    HomePage homePage;
    
    public HomePageTest() {
    	homePage=new HomePage(driver);
    }
    
	public void browserSelection() throws IOException {
		Properties prop = new Properties();
		FileReader fileReader = new FileReader(path);
		prop.load(fileReader);
		String browser = prop.getProperty("browser");
		String url = prop.getProperty("URL");
		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		} else if (browser.equals("Edge")) {
			driver = new EdgeDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}else if (browser.equals("FirefoxDriver")) {
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
		}else {
			System.out.println("No WebDriver Found, Hence ending the TestRun!!!!!");
		}
	}
 
    @Test
    public void navigateToIrctcHomePage() throws IOException {
        browserSelection();
        homePage.loginFeatureHomePage();
//        driver.quit();
    }

    @Test
    public  void navigateToPnrStatus() throws IOException, InterruptedException {
        browserSelection();
    	homePage=new HomePage(driver);
        homePage.pnrStatusButton("PNR Enquiry");
//        driver.quit();
    }

    @Test
    public void navigateToChartsAndVacancy() throws IOException {
        browserSelection();
        homePage.chartsAndVacancyButton();
//        driver.quit();
    }

    @Test
    public void navigateToFlightsPage() throws IOException {
        browserSelection();
        homePage.flightsHyperLink();
    }

}
