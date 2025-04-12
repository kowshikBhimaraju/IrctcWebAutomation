package Irctc.automation.Pnrstatus;

public class PnrStatusXpaths {
    public String PnrStatusButton = "//div[@class='hidden-xs']/div[@class='text-center pull-left']/a/label[@class='search_btn']";
    public String pnrNoEntry = "//input[@id='inputPnrNo']";
    public String submitButton = "//input[@id='modal1']";
    public String captchaCodeId = "CaptchaImgID";
    public String rtbStations = "//a[text()='Reserved Train Between Stations']";
    public String calendarRtbsImg = "(//*[contains(@title, 'Select date')]";
    public String calendarTableId = "ui-datepicker-div";
    public String sourceStationPnrEnquiry = "sourceStation";
    //input[@id='sourceStation']|//input[@placeholder='Enter Source Station']
}
