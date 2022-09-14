package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;


public class RegisterPage {

    public WebElement hoverInAccountAndList() {
        WebElement hoverInAccountAndList = Hooks.driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        return hoverInAccountAndList;
    }

    public WebElement createAmazonAcount() {
        WebElement createAmazonAcount = Hooks.driver.findElement(By.cssSelector("#createAccountSubmit"));
        return createAmazonAcount;
    }
    public WebElement solvePuzzleBtn(){
        WebElement solvePuzzleBtn = Hooks.driver.findElement(By.id("home_children_button"));
        return solvePuzzleBtn;
    }

    public WebElement continueBtn(){
        WebElement  continueBtn= Hooks.driver.findElement(By.cssSelector("#continue"));
        return continueBtn;
    }


    public WebElement nameTxtBox(){
        WebElement nameTxtBox=Hooks.driver.findElement(By.id("ap_customer_name"));
        return nameTxtBox;
    }


    public WebElement emailTxtBox(){
        WebElement emailTxtBox=Hooks.driver.findElement(By.id("ap_email"));
        return emailTxtBox;
    }
    public WebElement reEnterPassTxtBox(){
        WebElement reEnterPassTxtBox=Hooks.driver.findElement(By.cssSelector("#ap_password_check"));
        return reEnterPassTxtBox;
    }


    public WebElement passTxtBox(){
        WebElement passTxtBox=Hooks.driver.findElement(By.id("ap_password"));
        return passTxtBox;
    }
    public void enterEmail(String email){
        emailTxtBox().sendKeys(email);
    }

    public void enterPassword(String pass){
        passTxtBox().sendKeys(pass);
    }

    public void enterName(String name){
        nameTxtBox().sendKeys(name);
    }

    public void registrationPage() {
        Actions action = new Actions(Hooks.driver);
        action.click(hoverInAccountAndList()).build().perform();
        action.click(createAmazonAcount()).build().perform();
    }

    public void reEnterPassword(String pass){
        reEnterPassTxtBox().sendKeys(pass);
    }

    public void clickContinue(){
        continueBtn().click();
    }

    public void clickSolvePuzzle() throws InterruptedException {
        Thread.sleep(10000);
        WebDriverWait wait=new WebDriverWait(Hooks.driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(solvePuzzleBtn()));
        solvePuzzleBtn().click();
    }


}