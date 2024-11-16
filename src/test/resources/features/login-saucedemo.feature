@login
Feature: Login sauce demo
    Login sauce demo description

    @loginLockedOut
    Scenario: Login locked out user
        Given User type username "locked_out_user"
        Given User type password "secret_sauce"
        Then Should login locked out user

    @loginInvalid
    Scenario: Login username or password invalid
        Given User type username "invalid"
        Given User type password "error"
        Then Should login username and password invalid

    @loginSuccess
    Scenario: Login success and redirect to inventory page
        Given User type username "standard_user"
        Given User type password "secret_sauce"
        Then Should login success and redirect to inventory page