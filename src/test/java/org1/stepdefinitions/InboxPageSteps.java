package org1.stepdefinitions;

import io.cucumber.java.en.And;
import org.pageobject.pages.InboxPage;
import org.testng.Assert;

import static org1.stepdefinitions.BaseSteps.PAGES_STORAGE;
import static org1.stepdefinitions.EstimateModuleSteps.emailedEstimatedMonthlyCost;

public class InboxPageSteps {
    public static String estimatedCostFromEmail;

    @And("User from {string} checks the price of the selected Compute Engine in the new email")
    public String userFromGeneratesRandomEmail(String pageName) {

        return  estimatedCostFromEmail = ((InboxPage) PAGES_STORAGE.get(pageName)).checkEmailedEstimatedMonthlyCost();
    }

    @And("User checks that the emailed matches the result in the calculator")
    public void userChecksThatTheEmailedTotalEstimatedMonthlyCostMatchesTheResultInTheCalculator() {
        String regex = ".*?(\\d{1,3}[,.]\\d{1,3}[.]\\d{1,2}).*";

        String numberOfEstimatedFromCalculator = emailedEstimatedMonthlyCost
                .replaceAll(regex, "$1");
        String numberOfEstimatedFromEmail = estimatedCostFromEmail
                .replaceAll(regex, "$1");
        Assert.assertEquals(numberOfEstimatedFromCalculator, numberOfEstimatedFromEmail);

    }

}
