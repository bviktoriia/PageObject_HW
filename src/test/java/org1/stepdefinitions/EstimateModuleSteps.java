package org1.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.pageobject.modules.EstimateModule;


import static org1.stepdefinitions.BaseSteps.PAGES_STORAGE;
import static org1.stepdefinitions.BaseSteps.webDriver;

public class EstimateModuleSteps {

    public static String emailedEstimatedMonthlyCost;

    @And("User is on {string} gets actual price of the selected Compute Engine")
    public String userIsOnGetsActualPriceOfTheSelectedComputeEngine(String pageName) {

        return emailedEstimatedMonthlyCost=((EstimateModule) PAGES_STORAGE.get(pageName)).priceIsCalculated();
    }


        @And("^User is on \"([^\"]*)\" clicks on Send To Email button$")
        public void userIsOnSendToEmailButton(String pageName) {
            EstimateModule estimateModule = new EstimateModule(webDriver);
            PAGES_STORAGE.put(pageName, estimateModule);
            estimateModule.sendToEmail();
        }


    @Then("User from {string} opens Email Generating Page")
    public void userFromOpensEmailGeneratingPage(String pageName) {
        PAGES_STORAGE.put("Email Generating Page", ((EstimateModule) PAGES_STORAGE.get(pageName)).openNewTab());

    }
}
