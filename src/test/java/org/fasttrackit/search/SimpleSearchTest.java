package org.fasttrackit.search;

import org.fasttrackit.AppConfig;
import org.fasttrackit.TestBase;
import org.fasttrackit.webviews.Header;
import org.fasttrackit.webviews.ProductsGrid;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SimpleSearchTest extends TestBase{

        @Test
        public void SimpleSearchWithOneKeyword() {

            String keyword = "vase";
            Header header = PageFactory.initElements(driver, Header.class);

            header.search(keyword);

            ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);

            System.out.println("Stored " + productsGrid.getProductName().size() + " product names from search results.");

            for (WebElement productName : productsGrid.getProductName()) {

                assertThat("Some of the product names do not contain the searched keyword.", productName.getText(), containsString(keyword.toUpperCase()));

            }
        }
    }

