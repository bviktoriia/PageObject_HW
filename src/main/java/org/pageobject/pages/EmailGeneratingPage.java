package org.pageobject.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageobject.BasePage;

import java.time.Duration;

public class EmailGeneratingPage extends BasePage {
    @FindBy(xpath = "//div/h3[contains(text(), 'Random Email generator')]")
    private WebElement randomEmailGeneratorButton;
    private WebElement generatedText;
    private WebElement iFrame;
    private String myFrame = "myFrame";
    String generatedEmail;
    @FindBy(xpath = "//*[@id=\"input_615\"]")
    private WebElement emailField;
    @FindBy(xpath = "//button[contains(text(), 'Send Email')]")
    private WebElement sendEmailButton;
    @FindBy(xpath = "//div[@class=\"nw\"]/button[2]")
    private WebElement checkInboxButton;

    public EmailGeneratingPage(WebDriver webDriver) {
        super(webDriver);
    }

    public EmailGeneratingPage open() {
        webDriver.switchTo().newWindow(WindowType.TAB);
        webDriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "\t");
        webDriver.get("https://yopmail.com/en/");
        return this;
    }
    public EmailGeneratingPage changeTab() {
        String originalWindowHandle = webDriver.getWindowHandle();
        for (String windowHandle : webDriver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindowHandle)) {
                webDriver.switchTo().window(windowHandle);
                break;
            }
        }
        return this;
    }
    public EmailGeneratingPage generateEmail() {
        randomEmailGeneratorButton.click();
        webDriver.navigate().back();
        randomEmailGeneratorButton.click();
        copyGeneratedEmail();
        changeTab();
        webDriver.switchTo().frame(0);
        iFrame = new WebDriverWait(webDriver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(myFrame)));
        webDriver.switchTo().frame(myFrame);
        emailField.click();
        emailField.sendKeys(generatedEmail);
        sendEmailButton.click();
        changeTab();
        return new EmailGeneratingPage(webDriver);
    }
    public String copyGeneratedEmail(){
        generatedText = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='geny']")));
        generatedEmail = generatedText.getText();
        return generatedEmail;
    }
    public InboxPage goToInBoxPage() {
        webDriver.switchTo().defaultContent();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("window.scrollBy(0, 200);");
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,Duration.ofSeconds(10));
        checkInboxButton.click();
        return new InboxPage(webDriver);
    }
}
