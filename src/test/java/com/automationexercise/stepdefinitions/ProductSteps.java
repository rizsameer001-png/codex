package com.automationexercise.stepdefinitions;

import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.ProductsPage;
import com.automationexercise.utils.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ProductSteps {
    private final HomePage homePage = new HomePage(DriverFactory.getDriver());
    private final ProductsPage productsPage = new ProductsPage(DriverFactory.getDriver());

    @When("user navigates to products page")
    public void userNavigatesToProductsPage() {
        homePage.goToProducts();
        Assertions.assertTrue(productsPage.isAllProductsVisible(), "All products page did not load");
    }

    @When("user searches for product {string}")
    public void userSearchesForProduct(String productName) {
        productsPage.search(productName);
    }

    @Then("searched products section should be visible")
    public void searchedProductsSectionShouldBeVisible() {
        Assertions.assertTrue(productsPage.isSearchedProductsVisible(), "Searched products label not visible");
    }
}
