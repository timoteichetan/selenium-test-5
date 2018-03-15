package org.fasttrackit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TestBase {

    protected WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", AppConfig.getChromeDriverPath());
        driver = new ChromeDriver();
        driver.get(AppConfig.getSiteUrl());
    }

    protected void mouseOverAndClickLast(List<By> locators) {
        Actions actions = new Actions(driver);
        for (By locator : locators) {
            actions.moveToElement(driver.findElement(locator)).perform();
        }
        actions.click().perform();
    }






}
