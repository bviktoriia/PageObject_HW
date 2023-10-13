package org1.stepdefinitions;

import io.cucumber.java.en.And;
import org.pageobject.pages.CalculatorPage;

import static org1.stepdefinitions.BaseSteps.PAGES_STORAGE;

public class CalculatorPageSteps {


    @And("^User is navigate to the \"([^\"]*)\" and select Compute Engine form$")
    public void userIsNavigateToCalculatorPage(String pageName) {
            PAGES_STORAGE.put("Compute Engine Form Model",

        ((CalculatorPage) PAGES_STORAGE.get(pageName)).openComputeEngine());
    }

}
