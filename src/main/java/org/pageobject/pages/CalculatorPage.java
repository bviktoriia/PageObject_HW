package org.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageobject.BasePage;
import org.pageobject.modules.CumputEngineFormModule;

import java.time.Duration;

public class CalculatorPage extends BasePage {

    @FindBy(xpath = "//path[@fill=\"#BDC1C6\"]")
    private WebElement message;
    @FindBy(xpath = "//md-tab-item/div[@title=\"Compute Engine\"]")
    private WebElement computeEngine;

    public CalculatorPage(WebDriver webDriver) {
        super(webDriver);
    }


    public WebElement waitForVisibilityOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public CumputEngineFormModule openComputeEngine() {


        webDriver.switchTo().frame(0);
        WebElement iFrameElement = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myFrame\"]")));
        webDriver.switchTo().frame("myFrame");

        WebElement option = waitForVisibilityOf(computeEngine);
        option.click();



       webDriver.switchTo().defaultContent();

        return new CumputEngineFormModule(webDriver);
    }
}