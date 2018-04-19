package org.fasttrackit.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import org.fasttrackit.AppConfig;

import static org.fasttrackit.DriverFactory.driver;

public class HomePageSteps {

    @Given("^I open the homepage$")
    public void iOpenTheHomepage()  {
        driver.get(AppConfig.getSiteUrl());

    }
}
