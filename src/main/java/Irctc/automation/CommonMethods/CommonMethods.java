package Irctc.automation.CommonMethods;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class CommonMethods {
	WebDriver driver;
	String pathforScreenShot = "C:\\Users\\bhavy\\eclipse-workspace\\Work\\Irctc.web\\captchaImages\\captcha.png";

	public CommonMethods(WebDriver driver) {
		this.driver = driver;
	}

	public void waitFor(int Count) {
		for (int i = 0; i <= Count; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String randomTenDigit() {
		long randomNumber = (long) (Math.random() * 100000 * 10000);
		String concatinatedNumber = "7" + randomNumber;
		return concatinatedNumber;
	}

	public void captchaTextConverter(WebElement captchImageElement) throws IOException, TesseractException {
		File source = captchImageElement.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(source, new File(pathforScreenShot));
		tesserat(pathforScreenShot);
	}

	public String tesserat(String path) throws TesseractException {
		ITesseract image = new Tesseract();
		String imageOcr = image.doOCR(new File(path));
		System.out.println("----------------Image ORC Conversion Done-----------------");
		System.out.println("captcha VALUE" + imageOcr);
		return imageOcr;
	}

}
