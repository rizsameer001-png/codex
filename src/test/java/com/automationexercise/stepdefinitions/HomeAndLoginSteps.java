package com.automationexercise.stepdefinitions;

import com.automationexercise.config.FrameworkConfig;
import com.automationexercise.pages.HomePage;
import com.automationexercise.pages.LoginPage;
import com.automationexercise.utils.DriverFactory;
import com.automationexercise.utils.TestDataReader;
import com.fasterxml.jackson.databind.JsonNode;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class HomeAndLoginSteps {
    private final HomePage homePage = new HomePage(DriverFactory.getDriver());
    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("user launches Automation Exercise home page")
    public void userLaunchesAutomationExerciseHomePage() {
        homePage.open(FrameworkConfig.get("baseUrl", "https://automationexercise.com/"));
    }

    @Then("home page banner should be visible")
    public void homePageBannerShouldBeVisible() {
        Assertions.assertTrue(homePage.isHomeVisible(), "Home page banner is not visible");
    }

    @When("user navigates to signup login page")
    public void userNavigatesToSignupLoginPage() {
        homePage.goToSignupLogin();
    }

    @When("user logs in with invalid credentials from {string}")
    public void userLogsInWithInvalidCredentialsFrom(String dataPath) {
        JsonNode data = TestDataReader.get(dataPath);
        String email = data.get("invalidUser").get("email").asText();
        String password = data.get("invalidUser").get("password").asText();
        loginPage.login(email, password);
    }

    @Then("invalid login error should be displayed as {string}")
    public void invalidLoginErrorShouldBeDisplayedAs(String expectedError) {
        Assertions.assertEquals(expectedError, loginPage.loginError());
    }
}
