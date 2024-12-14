package Irctc.automation.CommonUtilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class CommonUtils {
	WebDriver driver1;
	WebDriverWait wait;

	public CommonUtils(WebDriver driver) {
		this.driver1 = driver;
	}

	public void webDriverWait() {
		wait=new WebDriverWait(driver1, Duration.ofSeconds(5));
	}
	
	}
