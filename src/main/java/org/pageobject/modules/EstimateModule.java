package org.pageobject.modules;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageobject.BasePage;
import org.pageobject.pages.EmailGeneratingPage;

import java.time.Duration;


    public class EstimateModule extends BasePage {
        @FindBy(xpath = "//md-card-content[@id='resultBlock']//h2[@class='md-title']/b[@class='ng-binding']")
        private WebElement priceField;

        @FindBy(xpath = "//md-card-content[@id='resultBlock']//button[@id='Email Estimate']")
        private WebElement emailEstimateField;

        public EstimateModule(WebDriver webDriver) {
            super(webDriver);
        }

        public WebElement waitForVisibilityOf(WebElement element) {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOf(element));
        }

        public EstimateModule sendToEmail() {
            emailEstimateField.click();
            return this;
        }
        public String priceIsCalculated() {
            WebElement option = waitForVisibilityOf(priceField);
            String actualPrice = option.getText();

            return actualPrice;
        }

        public EmailGeneratingPage openNewTab() {
            String originalWindowHandle = webDriver.getWindowHandle();
            for (String windowHandle : webDriver.getWindowHandles()) {
                if (!windowHandle.equals(originalWindowHandle)) {
                    webDriver.switchTo().window(windowHandle);
                    break;
                }
            }
            return new EmailGeneratingPage(webDriver);
        }
    }
