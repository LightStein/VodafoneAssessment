package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ShoppingBasketPage {
    public WebElement shoppingBasketIcon(){
        WebElement shoppingBasketIcon= Hooks.driver.findElement(By.xpath("//*[@id='nav-cart']"));
        return shoppingBasketIcon;
    }
    public List<WebElement> shoppingBasketItems(){
        List<WebElement> shoppingBasketItems=Hooks.driver.findElements(By.xpath("//div[@id='sc-active-cart']//*[@class='sc-list-item-content']"));
        return shoppingBasketItems;
    }
    public WebElement saveForLaterBtn(){
        WebElement saveForLaterBtn= Hooks.driver.findElement(By.xpath("//*[@class='sc-list-item-content']//*[@value='Save for later']"));
        return saveForLaterBtn;
    }
    public List<WebElement> saveForLaterItems(){
        List<WebElement> saveForLaterItems=Hooks.driver.findElements(By.xpath("//*[@id='sc-secondary-list']//div[@class='a-row sc-list-item sc-java-remote-feature']"));
        return saveForLaterItems;
    }
    public WebElement moveToBasketBtn(){
        WebElement moveToBasket=Hooks.driver.findElement(By.xpath("//*[@class='sc-list-item-content']//input[contains(@name,'submit.move-to-cart')]"));
        return moveToBasket;
    }
    public WebElement noItemsSavedForLater(){
        WebElement noItemsSavedForLater=Hooks.driver.findElement(By.xpath("//*[@id='sc-secondary-list']//*[contains(text(),'No items saved for later')]"));
        return noItemsSavedForLater;
    }
    public void saveForLater(){
        saveForLaterBtn().click();
    }

    public void moveBackToBsket(){
        moveToBasketBtn().click();
    }
    public void saveForLaterSuccessfully() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(saveForLaterItems().size() >= 1);
        softAssert.assertAll();
    }
    public void assertItems(){
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(shoppingBasketItems().size()>=1,"Basket is Empty!");
    }

    public void moveBackToBasketSuccessfully(){
        Assert.assertTrue(noItemsSavedForLater().isDisplayed());
    }
    public void OpenShoppingBasket(){
        shoppingBasketIcon().click();
    }
}
