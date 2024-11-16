# Tools QA

[SauceDemo Site para automatizar](https://www.saucedemo.com/)

## Instalar

```bash
mvn clean install -DskipTests
```

## Executar todos os testes

```bash
mvn test
```

## Executar teste por tag

```bash
mvn test -Dgroups=loginSuccess
```

## Executar teste pelo método da classe de teste

```bash
mvn test -Dtest=SauceDemoTest#loginSuccessTest
```

## Executar testes do cucumber

```bash
mvn test -Dtest=TestRunner
```

## Executar testes do cucumber com tags especificas

```bash
mvn test -Dtest=TestRunner -Dcucumber.filter.tags="@login or @error"
```

## Depurar teste do cucumber

Executar o modo depurar teste na classe TestRunner

## Executar teste com profile habilitando ou desabilitando o headless

Dev headless true

```bash
mvn test -Pdev
```

Prod headless false

```bash
mvn test -Pprod
```

## Criar cenários em português

```feature
# language: pt

# @login
# Funcionalidade: Login sauce demo
#     Login sauce demo description

#     @loginLockedOut
#     Cenário: Login locked out user
#         Dado User type username "locked_out_user"
#         Quando User type password "secret_sauce"
#         Então Should login locked out user
```
