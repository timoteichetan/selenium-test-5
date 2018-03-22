package org.fasttrackit.cart;

import org.fasttrackit.webviews.Header;
import org.fasttrackit.webviews.MiniCart;
import org.fasttrackit.webviews.ProductsGrid;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CartPopUp extends CartTest {


    @Test
    public void addProductAndCheckItInCart() {



        By accesoriesCategoryLocator = By.xpath("//a[text() = 'Accessories']");
        By eyewareCategoryLocator = By.xpath("//a[text() = 'Eyewear']");

        mouseOverAndClickLast(Arrays.asList(accesoriesCategoryLocator, eyewareCategoryLocator));

        ProductsGrid productsGrid = PageFactory.initElements(driver, ProductsGrid.class);

        productsGrid.getAddToCartButton().click();

        Header header = PageFactory.initElements(driver, Header.class);

        header.getCartPopUpButton().click();

        MiniCart miniCart = PageFactory.initElements(driver, MiniCart.class);

        miniCart.getQuantityField().clear();
        miniCart.getQuantityField().sendKeys("2");
        miniCart.getOkButton().click();


        String priceText = miniCart.getItemPrice().getText();
        String[] priceParts = priceText.split(" ");
        String priceValue = priceParts[0];
        priceValue=priceValue.replace(",", ".");


        String subtotalText = miniCart.getSubtotalPrice().getText();
        String[] subtotalParts = subtotalText.split(" ");
        String subtotalValue = subtotalParts[0];
        subtotalValue = subtotalValue.replace(",", ".");
        System.out.println(subtotalValue);


        double itemPrice = Double.parseDouble(priceValue);
        double itemSubtotalPrice = Double.parseDouble(subtotalValue);
        double quantity = Double.parseDouble(miniCart.getQuantityField().getAttribute("value"));
        assertThat("The subtotal price is incorrect", quantity * itemPrice, is(itemSubtotalPrice));

    }
}
