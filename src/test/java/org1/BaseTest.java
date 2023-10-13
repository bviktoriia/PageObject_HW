package org1;

import org.factory.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected final WebDriver webDriver = new WebDriverFactory().getWebDriver();
    @BeforeMethod
    protected void setUpWebDriver() {
        webDriver.manage().window().maximize();
    }

    @AfterMethod
    protected void quit() {
        webDriver.quit();
    }
}