package com.example.tools.qa.steps;

import org.junit.jupiter.api.Assertions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ErrorSaucedemoStep {
    private Boolean condition;

    @Given("eu tenho uma condição de erro")
    public void euTenhoUmaCondicaoDeErro() {
        condition = false;
    }

    @When("eu tento realizar uma ação que falha")
    public void euTentoRealizarUmaAcaoQueFalha() {
        if (!condition) {
            // Assertions.fail("A condição de erro foi encontrada e falhou conforme
            // esperado.");
        }
    }

    @Then("eu deveria ver uma falha")
    public void euDeveriaVerUmaFalha() {
        // Assertions.fail("Este é um teste de erro proposital.");
    }
}
