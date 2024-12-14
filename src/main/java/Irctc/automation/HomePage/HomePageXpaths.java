package Irctc.automation.HomePage;

public class HomePageXpaths {
	public String loginButtonXpath = "//a[text()=' LOGIN ']";
	public String loginUserNameTextXpath = "//input[@formcontrolname='userid']";
	public String loginPasswordTextXpath = "//input[@formcontrolname='password']";
	public String loginCaptchaXpath = "//img[@class='captcha-img']";
	public String loginCaptchaTextId = "captcha";
	public String loginSignInButtonXpath = "//button[text()='SIGN IN']";
	public String loginLogoutButtonXpath = "//a[@aria-label='Click here Logout from application']/span[text()='Logout']";
	public String MenuButton = "//div[@class='h_menu_drop_button hidden-xs']";
	public String PnrStatusButton = "//div[@class='hidden-xs']/div[@class='text-center pull-left']/a/label[@class='search_btn']";
	public String ChartsAndVacancyButton = "//*[@id=\"divMain\"]/div/app-main-page/div/div/div[1]/div[1]/div[1]/div[1]/div[2]/a/label";
	public String bookTicketText = "//label[text()=' BOOK TICKET ']";
	public String flightsHyperLink = "//a[@aria-label='Flight opens a new window']";

}
