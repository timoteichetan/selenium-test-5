package org.fasttrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsGrid {

    @FindBy(css = ".product-name a")
    private List<WebElement> productName;

    @FindBy(xpath = "//div[@class='actions']//button[@class='button btn-cart']")
    private WebElement addToCartButton;


    public List<WebElement> getProductName() {
        return productName;
    }

    public WebElement getAddToCartButton() { return addToCartButton; }

}
