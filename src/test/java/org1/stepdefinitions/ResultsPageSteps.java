package org1.stepdefinitions;

import io.cucumber.java.en.And;
import org.pageobject.pages.ResultsPage;

import static org1.stepdefinitions.BaseSteps.PAGES_STORAGE;

public class ResultsPageSteps {

        @And("^User is navigated to the \"([^\"]*)\" and select the needed result")
        public void userIsNavigateToTheResultsPage(String pageName){
            PAGES_STORAGE.put("Calculator Page", ((ResultsPage) PAGES_STORAGE.get(pageName)).googleCloudPricingCalculator());
        }
}
