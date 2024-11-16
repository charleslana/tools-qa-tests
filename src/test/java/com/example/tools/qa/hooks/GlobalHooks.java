package com.example.tools.qa.hooks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.example.tools.qa.Driver;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class GlobalHooks {
    @BeforeAll
    public static void setupAll() {
        System.out.println("Executando configuração global antes de todos os cenários");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.println("Executando limpeza global após todos os cenários");
    }

    @Before
    public void setUp() {
        System.out.println("Executando configuração antes de cada cenário");
    }

    @After
    public void tearDown() {
        System.out.println("Executando limpeza após cada cenário");
        Driver.quit();
    }

    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            captureScreenshot(scenario);
        }
    }

    private void captureScreenshot(Scenario scenario) {
        WebDriver driver = Driver.getDriver();
        if (driver instanceof TakesScreenshot) {
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            File screenshot = screenshotDriver.getScreenshotAs(OutputType.FILE);
            String pathStr = "src/test/resources/screenshots";
            Path path = Path.of(pathStr, "screenshot_" + scenario.getName() + ".png");
            try {
                Files.createDirectories(path.getParent());
                Files.copy(screenshot.toPath(), path);
                System.out.println("Captura de tela salva em: " + path.toString());
                scenario.attach(Files.readAllBytes(path), "image/png", "screenshot_" + scenario.getName() + ".png");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
