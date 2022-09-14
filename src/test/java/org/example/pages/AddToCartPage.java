package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AddToCartPage {
    public WebElement searchFeild(){
        WebElement searchFeild= Hooks.driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        return searchFeild;
    }
    public String searchPageWindowHandle() {
        String searchPageWindowHandle = Hooks.driver.getWindowHandle();
        return searchPageWindowHandle;
    }
    public WebElement searchResult1stItem() {
        WebElement  searchResult=Hooks.driver.findElement(By.xpath("//div[@class='sg-col-inner']//div//div//h2//a//span[@class='a-size-medium a-color-base a-text-normal']"));
        return searchResult;
    }

    public WebElement searchResult2stItem() {
        WebElement  searchResult=Hooks.driver.findElement(By.xpath("//*[@id='search']/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span"));
        return searchResult;
    }
    public WebElement addedToBasketAlert(){
        WebElement addedToBasketMsg=Hooks.driver.findElement(By.xpath("//*[contains(text(),'Added to Basket')]"));
        return addedToBasketMsg;
        ////*[@id='sw-atc-confirmation']
    }
    public WebElement addTocartBtn(){
        WebElement addTocartBtn=Hooks.driver.findElement(By.xpath("//div[@class='a-box-group']//input[@id='add-to-cart-button']"));
        return addTocartBtn;
    }
    public void searchResultPage(){
        Hooks.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        //  Hooks.driver.navigate().refresh();
        Hooks.driver.navigate().back();
        Hooks.driver.navigate().back();
    }
    public void searchFor(String item){
        Actions action=new Actions(Hooks.driver);
        action.click(searchFeild()).build().perform();
        action.sendKeys(item).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();

    }


    public void assertAddedToBasketSuccessAlert(){
        WebDriverWait wait=new WebDriverWait(Hooks.driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(addedToBasketAlert()));
        Assert.assertTrue(addedToBasketAlert().isDisplayed());
    }
    public void selectFirstItem(){
        searchResult1stItem().click();
        Hooks.driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    }
    public void selectSecondItem(){
        searchResult2stItem().click();
    }

    public boolean productAvailability(){
        WebElement ProductAvailability=Hooks.driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//div[@id='availabilityInsideBuyBox_feature_div']"));
         ProductAvailability.findElement(By.xpath("//*[contains(text(),'In stock')]"));
        return (ProductAvailability.isDisplayed());
    }

    public void checkProductAvailability(){
        Assert.assertTrue(productAvailability());
    }



    public void addToCart() throws InterruptedException {
        addTocartBtn().click();
        Hooks.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

}
