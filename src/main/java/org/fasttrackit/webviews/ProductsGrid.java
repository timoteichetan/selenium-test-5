package org.fasttrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductsGrid {

    @FindBy(css = ".product-name a")
    private List<WebElement> productName;

    @FindBy(xpath = "//div[@class='actions']//button[@class='button btn-cart']")
    private WebElement addToCartButton;

    @FindBy(css = ".sort-by select")
    private WebElement sortByList;


    @FindBy(className = "sort-by-switcher")
    private WebElement sortDirectionLink;

    public List<WebElement> getProductPrices() {
        return productPrices;
    }

    @FindBy(xpath = "//div[@class='price-box']//*[@class!='old-price']//*[@class='price']")
    private List<WebElement> productPrices;

    public List<WebElement> getProductName() {

        return productName;
    }


    public WebElement getAddToCartButton() { return addToCartButton; }

    public Select getSortByList() { return new Select(sortByList); }

    public WebElement getSortDirectionLink() { return sortDirectionLink; }

}
