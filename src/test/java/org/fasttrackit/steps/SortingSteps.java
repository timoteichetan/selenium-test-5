package org.fasttrackit.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.fasttrackit.TestBase;
import org.fasttrackit.webviews.ProductsGrid;
import org.openqa.selenium.By;

import java.util.Arrays;

public class SortingSteps extends TestBase{

    private ProductsGrid productsGrid = initElements(ProductsGrid.class);

    @When("^I sort the products by \"([^\"]*)\"$")
    public void iSortTheProductsBy(String criteria) {
        productsGrid.getSortByList().selectByVisibleText(criteria);
    }

    @And("^I sort the products in (.+) order$")
    public void iSortTheProductsInDescendingOrder(String sortDirection){
        String classValue = productsGrid.getSortDirectionLink().getAttribute("class");

        String expectedPartialClassValue;

        if (sortDirection.equals("descending")) {
            expectedPartialClassValue = "--asc";
        } else {
            expectedPartialClassValue = "--desc";
        }

        if (classValue.contains(expectedPartialClassValue)) {
            productsGrid.getSortDirectionLink().click();
        }
    }
}

