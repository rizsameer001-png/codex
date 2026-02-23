package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private final By allProductsTitle = By.cssSelector(".title.text-center");
    private final By searchInput = By.id("search_product");
    private final By searchButton = By.id("submit_search");
    private final By searchedProductsTitle = By.cssSelector(".title.text-center");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAllProductsVisible() {
        return waitUtils.visible(allProductsTitle).getText().contains("ALL PRODUCTS");
    }

    public void search(String productName) {
        waitUtils.visible(searchInput).clear();
        waitUtils.visible(searchInput).sendKeys(productName);
        waitUtils.clickableAndClick(searchButton);
    }

    public boolean isSearchedProductsVisible() {
        return waitUtils.visible(searchedProductsTitle).getText().contains("SEARCHED PRODUCTS");
    }
}
