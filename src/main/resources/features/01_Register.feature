
Feature: F01_Register | users could register with new accounts
Scenario: guest user could register with valid data successfully
      Given user go to register page
      When user Enter his name
      |Customer Name|
      And user Enter email
      |Customer Password|
      And user Enter password and confirmed this password
      |Customer Password|
      And user cick on Continue
     #And user Verify info using code Sent By amazon






