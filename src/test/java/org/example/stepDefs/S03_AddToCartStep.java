package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.AddToCartPage;

public class S03_AddToCartStep {
    AddToCartPage addToCart=new AddToCartPage();

    @And("user search for specific item {string}")
    public void userSearchForSpecificItemSearchWord(String item) {
        addToCart.searchFor(item);
        addToCart.searchPageWindowHandle();
    }

    @And("select first item and add it to the cart")
    public void selectFirstItemAndCheckItsAvailabilityAndAddToCart() throws InterruptedException {
        addToCart.selectFirstItem();
        addToCart.addToCart();
        addToCart.assertAddedToBasketSuccessAlert();
    }

    @And("customer go back and add the second item to the cart")
    public void customerGoBackAndAddTheSecondItemToTheCart() throws InterruptedException {
        addToCart.searchResultPage();
        addToCart.selectSecondItem();
        addToCart.addToCart();
        addToCart.assertAddedToBasketSuccessAlert();
    }

}
