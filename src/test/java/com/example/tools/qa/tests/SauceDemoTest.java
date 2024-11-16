package com.example.tools.qa.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.tools.qa.Driver;
import com.example.tools.qa.models.LoginModel;
import com.example.tools.qa.pages.SauceDemoPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Disabled("Reason: draft")
class SauceDemoTest {

    private SauceDemoPage sauceDemoPage;
    private static final Logger logger = LoggerFactory.getLogger(SauceDemoTest.class);

    @BeforeEach
    public void setUp() {
        sauceDemoPage = new SauceDemoPage();
    }

    @AfterEach
    public void tearDown() {
        Driver.quit();
    }

    @Order(2)
    @Test
    @DisplayName("Should login locked out user")
    void loginLockedOutUserTest() {
        logger.info("Should login locked out user");
        LoginModel loginModel = LoginModel.builder()
                .username("locked_out_user")
                .password("secret_sauce")
                .build();
        String message = sauceDemoPage.loginError(loginModel);
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", message);
    }

    @Order(1)
    @Test
    @Tag("loginInvalid")
    @DisplayName("Should login username and password invalid")
    void loginUsernameOrPasswordInvalidTest() {
        logger.info("Should login username and password invalid");
        LoginModel loginModel = LoginModel.builder()
                .username("invalid")
                .password("error")
                .build();
        String message = sauceDemoPage.loginError(loginModel);
        Assertions.assertEquals("Epic sadface: Username and password do not match any user in this service", message);
    }

    @Order(3)
    @Test
    @Tag("loginSuccess")
    @DisplayName("Should login success and redirect to inventory page")
    void loginSuccessTest() {
        logger.info("Should login success and redirect to inventory page");
        Driver.implicitlyWait(20L);
        LoginModel loginModel = LoginModel.builder()
                .username("standard_user")
                .password("secret_sauce")
                .build();
        String url = sauceDemoPage.loginSuccess(loginModel);
        Assertions.assertEquals(sauceDemoPage.getInventoryUrl(), url);
    }
}
