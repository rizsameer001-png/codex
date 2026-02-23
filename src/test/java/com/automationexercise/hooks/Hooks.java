package com.automationexercise.hooks;

import com.automationexercise.config.FrameworkConfig;
import com.automationexercise.utils.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        DriverFactory.initializeDriver();
        DriverFactory.getDriver().get(FrameworkConfig.get("baseUrl", "https://automationexercise.com/"));
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
