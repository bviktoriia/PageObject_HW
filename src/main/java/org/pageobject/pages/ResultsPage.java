package org.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.pageobject.BasePage;

public class ResultsPage extends BasePage {
    @FindBy(xpath = "//b[contains(text(),'Google Cloud Pricing Calculator')]")
    private WebElement googleCloudPricingCalculator;
    protected ResultsPage(WebDriver webDriver) {
        super(webDriver);
 }
    public WebElement getGoogleCloudPricingCalculator() {
        return googleCloudPricingCalculator;
    }


    public CalculatorPage googleCloudPricingCalculator() {
        googleCloudPricingCalculator.click();
        return new CalculatorPage(webDriver);
    }
}
