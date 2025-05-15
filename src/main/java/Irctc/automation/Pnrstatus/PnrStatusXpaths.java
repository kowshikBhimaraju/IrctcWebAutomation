package Irctc.automation.Pnrstatus;

public class PnrStatusXpaths {
    public String PnrStatusButton = "//div[@class='hidden-xs']/div[@class='text-center pull-left']/a/label[@class='search_btn']";
    public String pnrNoEntry = "//input[@id='inputPnrNo']";
    public String submitButton = "//input[@id='modal1']";
    public String captchaCodeId = "CaptchaImgID";
    public String rtbStations = "//a[text()='Reserved Train Between Stations']";
    public String calendarRtbsImg = "//img[@class='ui-datepicker-trigger']";
    public String calendarTableId = "ui-datepicker-div";
    public String sourceStationPnrEnquiry = "sourceStation";
    public String calenderLeftBlock = "//div[@class='ui-datepicker-group ui-datepicker-group-first']";
    public String secondSideCalander = "//div[@class='ui-datepicker-group ui-datepicker-group-last']";
    public String selectMonthName = "//div[@id='ui-datepicker-div']/div[contains(@class,'ui-datepicker-group-first')]/div/div/span";
    public String selectDateForFirsTable = "//div[@class='ui-datepicker-group ui-datepicker-group-first']/table/tbody";
    //input[@id='sourceStation']|//input[@placeholder='Enter Source Station']
}
