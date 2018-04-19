package org.fasttrackit.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import org.fasttrackit.TestBase;
import org.fasttrackit.webviews.ProductsGrid;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class VerifyProductsSortingSteps extends TestBase{
    private ProductsGrid productsGrid = initElements(ProductsGrid.class);

    @Then("^Products are sorted by \"([^\"]*)\" in (.+) order$")
    public void productsAreSortedByInDescendingOrder(String criteria, String sortDirection) {
        List<Double> actualPrices = new ArrayList<>();

        for (WebElement priceContainer : productsGrid.getProductPrices()) {
            String priceText = priceContainer.getText();

            String priceTextWithoutCurrency = priceText.split(" ")[0];

            priceTextWithoutCurrency = priceTextWithoutCurrency.replace(",", ".");


            double price = Double.parseDouble(priceTextWithoutCurrency);

            actualPrices.add(price);
        }

        List<Double> sortedPrice = new ArrayList<>(actualPrices);

        if (criteria.equals("Price")) {

        }

        Comparator<Double> comparator;

        if (sortDirection.equals("descending")) {
            comparator = Comparator.reverseOrder();
        } else {
            comparator = Comparator.naturalOrder();
        }


        sortedPrice.sort(comparator);

        assertThat("Products are not sorted correctly.", actualPrices, equalTo(sortedPrice));
    }
}
