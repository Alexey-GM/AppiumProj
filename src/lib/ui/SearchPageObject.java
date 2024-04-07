package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPageObject extends MainPageObject{
    private static final String
    SKIP_ONBOARDING = "//android.widget.Button[@resource-id=\"org.wikipedia:id/fragment_onboarding_skip_button\"]",
    SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
    SEARCH_INPUT = "//*[contains(@text, 'Search Wikipedia')]",
    SEARCH_RESULT = "//*[@resource-id=\"org.wikipedia:id/page_list_item_title\" and @text=\"{SUBSTRING}\"]",
    TITLE_RESULT = "//android.widget.TextView[@text='{SUBSTRING}']";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }
    public void initSearchInput() {
        this.waitForElementAndClick(By.xpath(SKIP_ONBOARDING), "Невозможно нажать на Skip", 15);
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT), "Невозможно нажать на поиск", 15);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Невозможно найти поле ввода", 15);
    }

    public void typeSearchLine(String search_line) {
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT), search_line, "Невозможно найти поле ввода", 15);
    }

    private static String getXpathSearchElement(String xpath, String substring){
        return xpath.replace("{SUBSTRING}", substring);
    }


    public void waitForSearchResult(String substring) {
        String search_result_xpath = getXpathSearchElement(SEARCH_RESULT, substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "невозможно найти " + search_result_xpath, 15);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "невозможно открыть " + search_result_xpath, 15);
    }

    public String waitForTitleResult(String title) {
        String title_xpath = getXpathSearchElement(TITLE_RESULT, title);
        WebElement title_element = waitForElementPresent(By.xpath(title_xpath), "Невозможно найти заголовок", 15);
        return title_element.getText();
    }


}
