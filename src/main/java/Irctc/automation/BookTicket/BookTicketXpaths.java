package Irctc.automation.BookTicket;

public class BookTicketXpaths {
    public String fromAutoSuggestiveDropDownInput = "#origin>span>input";
    //    public String fromAutoSuggestionInput = "//li[contains(@class,'ui-autocomplete-list-item')]/span[@class='ng-star-inserted']";
    public String fromDropDownSuggestions = ".ui-autocomplete-list-item >span";
    public String toAutoSuggestiveDropDownInput = "#destination>span>input";
    public String toDropDownSuggestions = ".ui-autocomplete-list-item>span";
    public String jourenyQuotaXpath = "(//p-dropdown/div/div/span)[3]";
    public String selectJounreyDate = "//p-calendar/span/input";
}
