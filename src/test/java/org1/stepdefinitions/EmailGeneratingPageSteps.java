package org1.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.pageobject.pages.EmailGeneratingPage;

import static org1.stepdefinitions.BaseSteps.PAGES_STORAGE;

public class EmailGeneratingPageSteps {
       @And("^User from \"([^\"]*)\" opens the https://yopmail\\.com/en/ page$")
       public void userIsNavigatedToEmailGeneratingPage(String pageName) {
           ((EmailGeneratingPage) PAGES_STORAGE.get(pageName)).open();
       }

        @And("User from {string} generates random email")
        public void userFromGeneratesRandomEmail(String pageName) {
            ((EmailGeneratingPage) PAGES_STORAGE.get(pageName)).generateEmail();
        }


    @Then("User from {string} navigates to Inbox Page")
    public void userFromNavigatesToInboxPage(String pageName) {
        PAGES_STORAGE.put("Inbox Page", ((EmailGeneratingPage) PAGES_STORAGE.get(pageName)).goToInBoxPage());

        }

}
