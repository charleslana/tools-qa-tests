package com.example.tools.qa;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

@Disabled
class DraftTest {

    @Test
    void loginTest() {
        Driver.setHeadless();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Driver.getDriver().get("https://www.saucedemo.com");
        Driver.getDriver().findElement(By.id("user-name")).sendKeys("locked_out_user");
        Driver.getDriver().findElement(By.id("password")).sendKeys("secret_sauce");
        Driver.getDriver().findElement(By.xpath("//input[@type='submit']")).click();
        String getErrorMessage = Driver.getDriver().findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assertions.assertEquals("Epic sadface: Sorry, this user has been locked out.", getErrorMessage);
        Driver.quit();
    }
}
