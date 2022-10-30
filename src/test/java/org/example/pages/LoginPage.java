package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.asserts.SoftAssert;

public class LoginPage {
    RegisterPage register=new RegisterPage();

    public WebElement loginEmailField(){
        WebElement loginEmailField = Hooks.driver.findElement(By.id("ap_email"));
        return loginEmailField;
    }
    public WebElement loginPasswordField(){
        WebElement loginPasswordField = Hooks.driver.findElement(By.id("ap_password"));
        return loginPasswordField;
    }
    public WebElement signInButton(){
        WebElement signInBtn = Hooks.driver.findElement(By.cssSelector("#signInSubmit"));
        return signInBtn;
    }

    public WebElement authErrorMessageBox(){
        WebElement authErrorMessageBoxElement = Hooks.driver.findElement(By.id("auth-error-message-box"));
        return authErrorMessageBoxElement;
    }

    public void loginPage(){
        Actions action = new Actions(Hooks.driver);
        action.click(register.hoverInAccountAndList()).build().perform();
    }

    public void clickSignInBtn(){
        signInButton().click();
    }

    public void enterEmail(String email){
        loginEmailField().sendKeys(email);
    }
    public void enterPassword(String pass){
        loginPasswordField().sendKeys(pass);
    }

    public void loginSuccessfullyAssertion(){
        SoftAssert softAssert=new SoftAssert();
        String actualURL = Hooks.driver.getCurrentUrl();
        System.out.println(actualURL);
        softAssert.assertTrue(actualURL.contains("signin"));
        softAssert.assertAll();
    }

    public void loginUnsuccessfulAssertion(){
        SoftAssert softAssert=new SoftAssert();
        String actualURL = Hooks.driver.getCurrentUrl();
        System.out.println(actualURL);
        softAssert.assertTrue(actualURL.contains("signin"));
        softAssert.assertTrue(authErrorMessageBox().isDisplayed());
        softAssert.assertAll();
    }
}
