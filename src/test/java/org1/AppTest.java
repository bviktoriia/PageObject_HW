package org1;


import org.pageobject.modules.EstimateModule;
import org.pageobject.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AppTest extends BaseTest {

    @Test
    public void searchTest() {
        HomePage homePage = new HomePage(webDriver);
        String totalEstimatedCost = homePage
                .open()
                .search("Google Cloud Platform Pricing Calculator")
                .googleCloudPricingCalculator()
                .openComputeEngine()
                .fillNumberOfInstances("4")
                .fillWhatFor("")
                .selectOperatingSystemSoftware("Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)")
                .selectProvisioningModel("Regular")
                .selectMachineFamily("General purpose")
                .selectSeries("N1")
                .selectMachineType("n1-standard-8 (vCPUs: 8, RAM: 30GB)")
                .checkAddGpus()
                .selectGpuType("NVIDIA Tesla V100")
                .selectNumberOfGpus(1)
                .selectLocalSsd("2x375 GB")
                .selectDatacenterLocation("Frankfurt (europe-west3)")
                .selectCommittedUsage("1 Year")
                .clickAddToEstimateButton()
                .priceIsCalculated();


        EstimateModule estimateModule = new EstimateModule(webDriver);
        String emailedEstimatedMonthlyCost = estimateModule
                .sendToEmail()
                .openNewTab()
                .open()
                .generateEmail()
                .goToInBoxPage()
                .checkEmailedEstimatedMonthlyCost();
        String regex = ".*?(\\d{1,3}[,.]\\d{1,3}[.]\\d{1,2}).*";
        String numberOfEstimated = totalEstimatedCost
                .replaceAll(regex, "$1");
        String numberOfEstimatedByEmail = emailedEstimatedMonthlyCost
                .replaceAll(regex, "$1");
        Assert.assertEquals(numberOfEstimated, numberOfEstimatedByEmail);
    }
}
