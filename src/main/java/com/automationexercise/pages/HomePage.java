package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final By signupLoginMenu = By.cssSelector("a[href='/login']");
    private final By productsMenu = By.cssSelector("a[href='/products']");
    private final By homeBanner = By.cssSelector("#slider");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open(String url) {
        driver.get(url);
    }

    public boolean isHomeVisible() {
        return waitUtils.visible(homeBanner).isDisplayed();
    }

    public void goToSignupLogin() {
        waitUtils.clickableAndClick(signupLoginMenu);
    }

    public void goToProducts() {
        waitUtils.clickableAndClick(productsMenu);
    }
}
