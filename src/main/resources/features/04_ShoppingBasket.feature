Feature: F04_ShoppingBasket| user could open Shopping Basket and be able to save the product for later and can move the product back to basket
  Scenario: user could save the product for later and can move the product back to basket
    Given user go to login page
    When user login with valid email "Customer Valid Email" and password "Customer Valid Password"
    And Open the Shopping Basket and check its Items
    And Save the Product for Later and check for Later Items
    Then move the product back to basket