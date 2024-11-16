package com.example.tools.qa;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Driver {
    private static WebDriver driver;
    private static Boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

    public static WebDriver getDriver() {
        if (driver == null) {
            return getNewDriver();
        }
        return driver;
    }

    public static void quit() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static void setHeadless() {
        headless = true;
    }

    public static void implicitlyWait(Long seconds) {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public static WebDriverWait getWait(Long seconds) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    private static WebDriver getNewDriver() {
        ChromeOptions options = new ChromeOptions();
        if (headless) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1920,1080");
        driver = new ChromeDriver(options);
        return driver;
    }
}
