package org.pageobject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pageobject.BasePage;

public class HomePage extends BasePage {
    @FindBy(xpath = "//div[@class='YSM5S']//input[@class='mb2a7b' and @name='q']")
    private WebElement searchIcon;

    @FindBy(xpath = "//div[@class='YSM5S SkvQFd']//input[@class='mb2a7b' and @name='q']")
    private WebElement searchField;

    public HomePage(WebDriver webDriver){
        super(webDriver);
    }

    public HomePage open() {
        webDriver.get("https://cloud.google.com/");
        return this;
    }

    public ResultsPage search(String searchEnter) {
        this.searchIcon.click();
        this.searchField.sendKeys(searchEnter);
        this.searchField.sendKeys(Keys.ENTER); // Нажать клавишу Enter
        return new ResultsPage(webDriver);
    }
}