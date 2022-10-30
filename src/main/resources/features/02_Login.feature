
Feature: F02_Login | users could use login functionality to use their accounts
  Scenario: user can't login with invalid email and password
    Given user goes to login page
    When user enters email "Invalid Email"
    Then user is prompted with invalid login error message
