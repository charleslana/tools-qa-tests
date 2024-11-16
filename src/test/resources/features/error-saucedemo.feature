@error
Feature: Teste de erro proposital
    Teste de erro proposital descrição

    Scenario: Teste que gera erro
        Given eu tenho uma condição de erro
        When eu tento realizar uma ação que falha
        Then eu deveria ver uma falha