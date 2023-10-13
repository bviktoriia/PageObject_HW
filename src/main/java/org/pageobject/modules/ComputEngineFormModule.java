package org.pageobject.modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pageobject.BasePage;

import java.time.Duration;

public class ComputEngineFormModule extends BasePage {




    @FindBy(xpath = "//input[@id=\"input_98\"]")
    private WebElement numberOfInstancesField;

    @FindBy(xpath = "//input[@id=\"input_99\"]")
    private WebElement whatForField;

    @FindBy(xpath = "//*[@id='select_value_label_90']")
    private WebElement operatingSystemSoftwareField;

    @FindBy(xpath = "//*[@id=\"select_115\"]")
    private WebElement provisioningModelField;

    @FindBy(xpath = "//*[@id='select_value_label_92']")
    private WebElement machineFamilyField;

    @FindBy(xpath = "//*[@id='select_value_label_93']")
    private WebElement seriesField;

    @FindBy(xpath = "//*[@id='select_value_label_94']")
    private WebElement machineTypeField;

    @FindBy(xpath = "//md-checkbox[@aria-label=\"Add GPUs\"][1]")
    private WebElement addGpusCheckBox;

    @FindBy(xpath = "//md-select[@id=\"select_505\"]")
    private WebElement gpuTypeField;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement numberOfGpusField;

    @FindBy(xpath = "//*[@id=\"select_value_label_463\"]")
    private WebElement localSsdField;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterlocationField;

    @FindBy(xpath = "//*[@id=\"select_value_label_97\"]")
    private WebElement committedUsageField;

    @FindBy(xpath = "//button[contains(text(), 'Add to Estimate')][1]")
    private WebElement addToEstimateButton;


        public ComputEngineFormModule(WebDriver webDriver) {
            super(webDriver);
        }

        private void switchToFrame() {
            webDriver.switchTo().frame(0);
            WebElement iFrameElement = new WebDriverWait(webDriver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"myFrame\"]")));
            webDriver.switchTo().frame("myFrame");
        }

        private void switchToDefaultContent() {
            webDriver.switchTo().defaultContent();
        }

    public WebElement waitForVisibilityOf(WebElement element) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


        public ComputEngineFormModule fillNumberOfInstances(String value) {
            switchToFrame();
            numberOfInstancesField.sendKeys(value);
            return this;
        }

       public ComputEngineFormModule fillWhatFor(String value) {
            whatForField.sendKeys(value);
            return this;
        }

       public ComputEngineFormModule selectOperatingSystemSoftware(String value) {

            operatingSystemSoftwareField.click();

            WebElement option = waitForVisibilityOf(webDriver.findElement(By.xpath("//md-option[@value='free']/div[contains(., '" + value + "')]")));
            option.click();

            return this;
       }

        public ComputEngineFormModule selectProvisioningModel(String value) {

        provisioningModelField.click();


        WebElement option = waitForVisibilityOf(webDriver.findElement(By.xpath("//md-option[@value='" + value.toLowerCase() + "']")));
        option.click();

        return this;
    }


    public ComputEngineFormModule selectMachineFamily(String value) {

        machineFamilyField.click();

        WebElement option = waitForVisibilityOf(webDriver.findElement(By.xpath("//md-option[@value='gp']/div[contains(., '" + value + "')]")));
        option.click();

        return this;
    }

    public ComputEngineFormModule selectSeries(String value) {

        seriesField.click();

        WebElement option = waitForVisibilityOf(webDriver.findElement(By.xpath("//div[@id=\"select_container_124\"]//md-content[@class=\"_md\"]/md-option")));
        option.click();

        return this;
    }


        public ComputEngineFormModule selectMachineType(String value) {

            machineTypeField.click();

            WebElement option = webDriver.findElement(By.xpath("//md-option/div[contains(text(), '" + value + "')]"));
            option.click();

            return this;
        }

        public ComputEngineFormModule checkAddGpus() {

            addGpusCheckBox.click();

            return this;
        }

        public ComputEngineFormModule selectGpuType (String value) {

            gpuTypeField.click();

            WebElement option = waitForVisibilityOf(webDriver.findElement(By.xpath("//md-option/div[contains(text(), '" + value + "')]")));
            option.click();

            return this;
        }

    public ComputEngineFormModule selectNumberOfGpus(Integer value) {
        numberOfGpusField.click();

        WebElement option = waitForVisibilityOf(webDriver.findElement(By.xpath("//md-option[contains(@ng-repeat,'.computeServer.gpuType')][@value='" +value +"']")));
        option.click();

        return this;
    }

    public ComputEngineFormModule selectLocalSsd(String value) {

            localSsdField.click();

            WebElement option = waitForVisibilityOf(webDriver.findElement(By.xpath("//md-option/div[contains(text(), '" + value + "')]")));
            option.click();

              return this;
        }

        public ComputEngineFormModule selectDatacenterLocation(String value) {

            datacenterlocationField.click();

            WebElement option = waitForVisibilityOf(webDriver.findElement(By.xpath("//md-option[@ ng-repeat=\"item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer\"]/div[contains(text(), '" + value + "')]")));

            option.click();

            return this;
        }

        public ComputEngineFormModule selectCommittedUsage(String value) {

            committedUsageField.click();

            WebElement option = waitForVisibilityOf(webDriver.findElement(By.xpath("//div[@id='select_container_139']//div[@class='md-text'][text()='" + value + "']")));
            option.click();

            return this;
        }

        public EstimateModule clickAddToEstimateButton() {

            addToEstimateButton.click();
            return new EstimateModule(webDriver);
        }
    }

