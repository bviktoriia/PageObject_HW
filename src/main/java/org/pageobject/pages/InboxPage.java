package org.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageobject.BasePage;

import java.time.Duration;

public class InboxPage extends BasePage {
    @FindBy(xpath = "//tr/td[2]/h3")
    private WebElement estimatedCostText;
    private WebElement iFrame;
    private String ifMailFrame = "ifmail";

    protected InboxPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String checkEmailedEstimatedMonthlyCost() {
        webDriver.navigate().refresh();
        iFrame = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(ifMailFrame)));
        webDriver.switchTo().frame(ifMailFrame);
        waitForElements(estimatedCostText);
        return estimatedCostText.getText();
    }
}