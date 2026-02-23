package com.automationexercise.utils;

import com.automationexercise.config.FrameworkConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        long waitSeconds = Long.parseLong(FrameworkConfig.get("explicitWaitSeconds", "20"));
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(waitSeconds));
    }

    public WebElement visible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void clickableAndClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public boolean textPresent(By locator, String text) {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public String title() {
        return driver.getTitle();
    }
}
