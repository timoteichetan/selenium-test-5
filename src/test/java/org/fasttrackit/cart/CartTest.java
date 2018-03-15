package org.fasttrackit.cart;

import org.fasttrackit.AppConfig;
import org.fasttrackit.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import sun.misc.PerformanceLogger;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartTest extends TestBase{

//    @Test
//    public void addProductToCart() {
//
//
//        driver.findElement(By.className("input-text")).sendKeys("vase" + Keys.ENTER);
//
//        driver.findElement(By.xpath("//div[@class='product-info' and ./descendant::*[text() = 'Herald Glass Vase' ]]//button[contains (@class, 'btn-cart')]")).click();
//
//        WebElement successMessageContainer = driver.findElement(By.cssSelector(".success-msg"));
//        assertThat("Product not added to card.", successMessageContainer.getText(), containsString("Herald Glass Vase"));


        @Test
        public void addProductWithSpecificSizeAndColorToCart() {

            By womenCategoryLocator = By.xpath("//a[text() = 'Women']");
            By newArrivalSubCategoryLocator = By.xpath("//a[text() = 'New Arrivals']");


            mouseOverAndClickLast(Arrays.asList(womenCategoryLocator, newArrivalSubCategoryLocator));

            driver.findElement(By.linkText("VIEW DETAILS")).click();

            driver.findElement(By.xpath("//img[@src = 'https://fasttrackit.org/selenium-test/media/catalog/swatches/1/21x21/media/pink.png']")).click();

            driver.findElement(By.id("swatch79")).click();

            driver.findElement(By.xpath("//button [@onclick = 'productAddToCartForm.submit(this)']")).click();

            WebElement succesfullPink = driver.findElement(By.xpath("(//dd)[3]"));
            assertThat("The product isn't pink.", succesfullPink.getText(), is("Pink"));
            WebElement succesfullM = driver.findElement(By.xpath("(//dd)[4]"));
            assertThat("The product isn't M size.", succesfullM.getText(), is("M"));

        }
    }





