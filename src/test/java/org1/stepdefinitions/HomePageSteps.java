package org1.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.pageobject.pages.HomePage;

import static org1.stepdefinitions.BaseSteps.PAGES_STORAGE;
import static org1.stepdefinitions.BaseSteps.webDriver;

public class HomePageSteps {

    @Given("^User is on \"([^\"]*)\"$")
    public void userIsOnGooglePage(String pageName){
    HomePage homePage = new HomePage(webDriver);

    PAGES_STORAGE.put(pageName, homePage);
    homePage.open();
    }

    @When("User enters searchEnter as {string} into the search field on {string}")
    public void userEntersSearchEnterAsIntoTheSearchFieldOn(String searchEnter, String pageName) {
        PAGES_STORAGE.put("Results Page", ((HomePage) PAGES_STORAGE.get(pageName)).search(searchEnter));
    }

}

