package org.fasttrackit.webviews;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header {

    @FindBy(id = "search")
    private WebElement searchField;

    @FindBy(id = "select-language")
    private WebElement languageDropDownList;

    @FindBy(xpath = "//div[@class = 'header-minicart'] //a//span[@class='label']")
    private WebElement cartPopUpButton;


    public void search(String keyword) {
        searchField.sendKeys(keyword + Keys.ENTER);
        System.out.println("Pressed Enter in search Field.");

    }


    public WebElement getSearchField() {
        return searchField;
    }


    public WebElement getLanguageDropDownList() {
        return languageDropDownList;
    }

    public WebElement getCartPopUpButton() { return cartPopUpButton; }

}
