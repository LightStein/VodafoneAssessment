package org.example.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.example.pages.RegisterPage;
import org.openqa.selenium.By;

import java.util.List;

public class S02_LoginStep {

    LoginPage login = new LoginPage();
    RegisterPage register=new RegisterPage();

    @Given("user go to login page")
    public void userGoToLoginPage() {
        login.loginPage();
    }

    @When("user login with valid email {string} and password {string}")
    public void userLoginWithValidEmailAndPassword(String email , String password) {
        login.enterEmail(email);
        register.clickContinue();
        login.enterPassword(password);
        login.clickSignInBtn();
    }

    @Then("user login to the system successfully")
    public void userLoginToTheSystemSuccessfully() {
        login.loginSuccessfullyAssertion();
    }
}
