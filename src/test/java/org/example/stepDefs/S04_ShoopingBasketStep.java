package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pages.ShoppingBasketPage;

public class S04_ShoopingBasketStep {

    ShoppingBasketPage shoppingBasket=new ShoppingBasketPage();

    @And("Open the Shopping Basket and check its Items")
    public void openTheShoppingBasketAndCheckItsItems() {
        shoppingBasket.OpenShoppingBasket();
        shoppingBasket.assertItems();
    }

    @And("Save the Product for Later and check for Later Items")
    public void saveTheProductForLater() {
        shoppingBasket.saveForLater();
        shoppingBasket.saveForLaterSuccessfully();
    }

    @Then("move the product back to basket")
    public void moveTheProductBackToBasket() {
        shoppingBasket.moveBackToBsket();
        shoppingBasket.moveBackToBasketSuccessfully();
    }
}
