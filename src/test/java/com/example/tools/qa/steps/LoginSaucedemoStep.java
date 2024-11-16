package com.example.tools.qa.steps;

import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.tools.qa.KeyValueStore;
import com.example.tools.qa.models.LoginModel;
import com.example.tools.qa.pages.SauceDemoPage;
import com.example.tools.qa.utils.ConstantsUtils;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSaucedemoStep {
    private static final Logger logger = LoggerFactory.getLogger(LoginSaucedemoStep.class);
    private LoginModel loginModel;
    private SauceDemoPage sauceDemoPage;

    @Before
    public void setUp() {
        loginModel = new LoginModel();
        sauceDemoPage = new SauceDemoPage();
    }

    @Given("User type username {string}")
    public void userTypeUsername(String username) {
        logger.info("User type username {}", username);
        KeyValueStore.getInstance().set("username", username);
        loginModel.setUsername(username);
    }

    @When("User type password {string}")
    public void userTypePassword(String password) {
        logger.info("User type password {}", password);
        loginModel.setPassword(password);
    }

    @Then("Should login locked out user")
    public void shouldLoginLockedOutUser() {
        logger.info("Should login locked out user");
        String message = sauceDemoPage.loginError(loginModel);
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", message);
    }

    @Then("Should login username and password invalid")
    public void shouldLoginUsernameAndPasswordInvalid() {
        logger.info("Should login username and password invalid");
        String message = sauceDemoPage.loginError(loginModel);
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", message);
    }

    @Then("Should login success and redirect to inventory page")
    public void shouldLoginSuccessAndRedirectToInventoryPage() {
        loginModel.setUsername(ConstantsUtils.USERNAME);
        loginModel.setPassword(ConstantsUtils.PASSWORD);
        String url = sauceDemoPage.loginSuccess(loginModel);
        Assertions.assertEquals(sauceDemoPage.getInventoryUrl(), url);
    }
}
