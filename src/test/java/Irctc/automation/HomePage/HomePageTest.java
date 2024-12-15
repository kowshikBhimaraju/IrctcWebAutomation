package Irctc.automation.HomePage;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.TesseractException;

public class HomePageTest {

	public String path = "C:\\Users\\bhavy\\eclipse-workspace\\Work\\Irctc.web\\DataProvider.properties";
	public static WebDriver driver;
	HomePage homePage;

	public HomePageTest() {
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
		} else if (browser.equals("FirefoxDriver")) {
			driver = new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
		} else {
			System.out.println("No WebDriver Found, Hence ending the TestRun!!!!!");
		}
	}

	@Test
	public void loginButtonHomePage() throws IOException, InterruptedException {
		browserSelection();
		homePage = new HomePage(driver);
		homePage.loginFeatureHomePage();
	}

	@Test
	public void registerButtonHomePage() throws IOException, InterruptedException, TesseractException {
		browserSelection();
		homePage = new HomePage(driver);
		homePage.registerButtonHomePage();
	}

	@Test
	public void navigateToPnrStatus() throws IOException, InterruptedException {
		browserSelection();
		homePage = new HomePage(driver);
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
