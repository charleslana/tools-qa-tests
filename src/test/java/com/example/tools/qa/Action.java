package com.example.tools.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public abstract class Action {
    private Long waitTime = 10L;

    public void navigation(String url) {
        Driver.getDriver().get(url);
    }

    public void sendKeysById(String id, CharSequence text) {
        Driver.getDriver().findElement(By.id(id)).sendKeys(text);
    }

    public void clickByXpath(String xpath) {
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }

    public String getTextByXpath(String xpath) {
        return Driver.getDriver().findElement(By.xpath(xpath)).getText();
    }

    public void waitForUrl(String url) {
        Driver.getWait(waitTime).until(ExpectedConditions.urlToBe(url));
    }

    public String getUrl() {
        return Driver.getDriver().getCurrentUrl();
    }

    @SuppressWarnings("java:S2925")
    public void sleep(Long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
