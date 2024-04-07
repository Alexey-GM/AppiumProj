package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AddHobbitToListAndDeleteObject extends MainPageObject {
    private static final String
            SKIP_ONBOARDING = "//android.widget.Button[@resource-id=\"org.wikipedia:id/fragment_onboarding_skip_button\"]",
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_RESULT = "//*[@resource-id=\"org.wikipedia:id/page_list_item_title\" and @text=\"{SUBSTRING}\"]",
            BUTTON_SAVE = "//*[@resource-id=\"org.wikipedia:id/page_save\"]",
            SNACK_BUTTON_ADD = "//*[@text='Add to list']",
            CREATE_BUTTON = "//*[@resource-id=\"org.wikipedia:id/create_button\"]",
            LIST_NAME_INPUT = "//*[@resource-id=\"org.wikipedia:id/text_input\"]",
            BUTTON_OK = "//*[@resource-id=\"android:id/button1\"]",
            NAVIGATE_UP = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]",
            LISTS_FOR_READING = "//*[@resource-id=\"org.wikipedia:id/nav_tab_reading_lists\"]",
            READING_LIST_RESULT = "//*[@resource-id=\"org.wikipedia:id/item_title\" and @text=\"{SUBSTRING}\"]",
            OVERFLOW_MENU = "//*[@resource-id=\"org.wikipedia:id/item_overflow_menu\"]",
            DELETE_BUTTON = "//android.widget.TextView[@resource-id=\"org.wikipedia:id/title\" and @text=\"Delete list\"]";


    public AddHobbitToListAndDeleteObject(AppiumDriver driver) {
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

    private static String getXpathSearchElement(String xpath, String substring) {
        return xpath.replace("{SUBSTRING}", substring);
    }

    public void waitForSearchResult(String substring) {
        String search_result_xpath = getXpathSearchElement(SEARCH_RESULT, substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "невозможно найти " + search_result_xpath, 15);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "невозможно открыть " + search_result_xpath, 15);
    }

    public void createListAndAddFilm(String listName) {
        this.waitForElementAndClick(By.xpath(BUTTON_SAVE), "невозможно нажать button save", 15);
        this.waitForElementAndClick(By.xpath(SNACK_BUTTON_ADD), "Невозможно нажать add to list", 15);
        this.waitForElementAndClick(By.xpath(LIST_NAME_INPUT), "Невозможно нажать на list name input", 15);
        this.waitForElementPresent(By.xpath(LIST_NAME_INPUT), "Невозможно найти поле ввода", 15);
        this.waitForElementAndSendKeys(By.xpath(LIST_NAME_INPUT), listName, "Невозможно найти поле ввода", 15);
        this.waitForElementAndClick(By.xpath(BUTTON_OK), "Невозможно нажать на OK", 15);
        this.waitForElementAndClick(By.xpath(NAVIGATE_UP), "Невозможно нажать на BACK", 15);
        this.waitForElementPresent(By.xpath(NAVIGATE_UP), "Невозможно найти navigate back", 15);
        this.waitForElementAndClick(By.xpath(NAVIGATE_UP), "Невозможно нажать на BACK", 15);
    }

    public void deleteList(String listName) {
        this.waitForElementAndClick(By.xpath(LISTS_FOR_READING), "невозможно нажать на Lists", 15);
        String listXpath = getXpathSearchElement(READING_LIST_RESULT, listName);
        this.waitForElementAndClick(By.xpath(listXpath), "невозможно найти список", 15);
        this.waitForElementPresent(By.xpath(listXpath), "Невозможно отобразить список", 15);
        this.waitForElementAndClick(By.xpath(OVERFLOW_MENU), "невозможно нажать троеточие", 15);
        this.waitForElementAndClick(By.xpath(DELETE_BUTTON), "невозможно нажать удалить список", 15);
        this.waitForElementAndClick(By.xpath(BUTTON_OK), "Невозможно нажать на OK", 15);
    }
}
