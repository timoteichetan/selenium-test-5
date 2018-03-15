package org.fasttrackit.webviews;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MiniCart {



    @FindBy(xpath = "//td//input")
    private WebElement quantityField;

    @FindBy(xpath = "//p//span[@class='price']")
    private WebElement subtotalPrice;

    @FindBy(xpath = "//td//span[@class='price']")
    private WebElement itemPrice;

    @FindBy(xpath = "//td//button")
    private WebElement okButton;

    public WebElement getQuantityField() { return quantityField; }

    public WebElement getSubtotalPrice() { return subtotalPrice; }

    public WebElement getItemPrice() { return itemPrice; }

    public WebElement getOkButton() { return okButton; }

}
