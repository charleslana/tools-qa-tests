package com.example.tools.qa.pages;

import com.example.tools.qa.Action;
import com.example.tools.qa.KeyValueStore;
import com.example.tools.qa.models.LoginModel;

public class SauceDemoPage {
    public SauceDemoPage() {
        action = new Action() {
        };
    }

    private final Action action;

    private final String url = "https://www.saucedemo.com";
    private final String inputUserName = "user-name";
    private final String inputPassword = "password";
    private final String loginButton = "//input[@type='submit']";
    private final String errorMessage = "//h3[@data-test='error']";

    public String loginError(LoginModel model) {
        action.navigation(url);
        action.sendKeysById(inputUserName, model.getUsername());
        action.sendKeysById(inputPassword, model.getPassword());
        action.clickByXpath(loginButton);
        System.out.printf("Buscando value da key: %s", KeyValueStore.getInstance().get("username"));
        return action.getTextByXpath(errorMessage);
    }

    public String loginSuccess(LoginModel model) {
        action.navigation(url);
        action.sendKeysById(inputUserName, model.getUsername());
        action.sendKeysById(inputPassword, model.getPassword());
        action.clickByXpath(loginButton);
        action.waitForUrl(getInventoryUrl());
        action.sleep(2000L);
        return action.getUrl();
    }

    public String getInventoryUrl() {
        return url.concat("/inventory.html");
    }
}
