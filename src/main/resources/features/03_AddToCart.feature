Feature: F03_Search | user could search and add Item To the cart and Validate Whenever That added Successfully
  Scenario Outline: user could search and add the specified Searched item To the cart and check the Cart
    Given user go to login page
    When user login with valid email "Customer Valid Email" and password "Customer Valid Password"
    And user search for specific item <item>
    And select first item and add it to the cart
    And customer go back and add the second item to the cart
   #Then Validate that items are added successfully

    Examples:
    |item|
    |"Drucker"|