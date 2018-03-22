package org.fasttrackit;


import cucumber.api.java.Before;

public class Hooks {
    @Before
    public void setup() {
        String browser = System.getProperty("browser", "chrome");
        DriverFactory.initWebDriver(browser);
        DriverFactory.getDriver().get(AppConfig.getSiteUrl());
    }
}
