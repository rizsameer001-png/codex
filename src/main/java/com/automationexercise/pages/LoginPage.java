package com.automationexercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By loginEmail = By.cssSelector("input[data-qa='login-email']");
    private final By loginPassword = By.cssSelector("input[data-qa='login-password']");
    private final By loginButton = By.cssSelector("button[data-qa='login-button']");
    private final By errorMessage = By.cssSelector("form[action='/login'] p");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password) {
        waitUtils.visible(loginEmail).clear();
        waitUtils.visible(loginEmail).sendKeys(email);
        waitUtils.visible(loginPassword).clear();
        waitUtils.visible(loginPassword).sendKeys(password);
        waitUtils.clickableAndClick(loginButton);
    }

    public String loginError() {
        return waitUtils.visible(errorMessage).getText().trim();
    }
}
