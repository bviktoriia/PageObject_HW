package org1;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org1.stepdefinitions"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
