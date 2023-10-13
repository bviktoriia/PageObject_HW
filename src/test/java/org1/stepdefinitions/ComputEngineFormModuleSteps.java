package org1.stepdefinitions;

import io.cucumber.java.en.And;
import org.pageobject.modules.ComputEngineFormModule;

import static org1.stepdefinitions.BaseSteps.PAGES_STORAGE;

public class ComputEngineFormModuleSteps {

    @And("User is on {string} and fills value as {string} in Number Of Instances field")
    public void userFillsValueInNumberOfInstancesField(String pageName, String value){
        ((ComputEngineFormModule) PAGES_STORAGE.get(pageName)).fillNumberOfInstances(value);
    }

    @And("User is on {string} fills value as {string} in fill What For field")
    public void userIsOnFillsValueAsInFillWhatForField(String pageName, String value){
        ((ComputEngineFormModule) PAGES_STORAGE.get(pageName)).fillWhatFor(value);

    }

    @And("User is on {string} fills value as {string} in Operating System Software field")
    public void userIsOnFillsValueAsInOperatingSystemSoftwareField(String pageName, String value) {
        ((ComputEngineFormModule) PAGES_STORAGE.get(pageName)).selectOperatingSystemSoftware(value);
    }

    @And("User is on {string} fills value as {string} in Provisioning Model field")
    public void userIsOnFillsValueAsInProvisioningModelField(String pageName, String value) {
        ((ComputEngineFormModule) PAGES_STORAGE.get(pageName)).selectProvisioningModel(value);
    }

    @And("User is on {string} fills value as {string} in Machine Family field")
    public void userIsOnFillsValueAsInMachineFamilyField(String pageName, String value) {
        ((ComputEngineFormModule) PAGES_STORAGE.get(pageName)).selectMachineFamily(value);
    }

    @And("User is on {string} fills value as {string} in Series field")
    public void userIsOnFillsValueAsInSeriesField(String pageName, String value) {
        ((ComputEngineFormModule) PAGES_STORAGE.get(pageName)).selectSeries(value);
    }

    @And("User is on {string} fills value as {string} in Machine Type field")
    public void userIsOnFillsValueAsInMachineTypeField(String pageName, String value) {
        ((ComputEngineFormModule) PAGES_STORAGE.get(pageName)).selectMachineType(value);
    }

    @And("User is on {string} select option in Add GPUs field")
    public void userIsOnSelectOptionInAddGPUsField(String pageName) {
        ((ComputEngineFormModule) PAGES_STORAGE.get(pageName)).checkAddGpus();
    }

    @And("User is on {string} fills value as {string} in GPU Type field")
    public void userIsOnFillsValueAsInGPUTypeField(String pageName, String value) {
        ((ComputEngineFormModule) PAGES_STORAGE.get(pageName)).selectGpuType(value);
    }

    @And("User is on {string} fills value as {int} in Number Of GPUs field")
    public void userIsOnFillsValueAsInNumberOfGPUsField(String pageName, Integer value) {
        ((ComputEngineFormModule) PAGES_STORAGE.get(pageName)).selectNumberOfGpus(value);
    }

    @And("User is on {string} fills value as {string} in Local SSD field")
    public void userIsOnFillsValueAsInLocalSSDField(String pageName, String value) {
        ((ComputEngineFormModule) PAGES_STORAGE.get(pageName)).selectLocalSsd(value);
    }

    @And("User is on {string} fills value as {string} in Datacenter Location field")
    public void userIsOnFillsValueAsInDatacenterLocationField(String pageName, String value) {
        ((ComputEngineFormModule) PAGES_STORAGE.get(pageName)).selectDatacenterLocation(value);
    }

    @And("User is on {string} fills value as {string} in Committed Usage field")
    public void userIsOnFillsValueAsInCommittedUsageField(String pageName, String value) {
        ((ComputEngineFormModule) PAGES_STORAGE.get(pageName)).selectCommittedUsage(value);
    }

    @And("User is on {string} clicks on Add To Estimate button")
    public void userIsOnClicksOnAddToEstimateButton(String pageName) {
        PAGES_STORAGE.put("Estimate Module", ((ComputEngineFormModule) PAGES_STORAGE.get(pageName)).clickAddToEstimateButton());
    }
}
