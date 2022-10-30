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

    @Given("user goes to login page")
    public void userGoToLoginPage() {
        login.loginPage();
    }

    @When("user enters email {string} and password {string}")
    public void userLoginWithValidEmailAndPassword(String email , String password) {
        login.enterEmail(email);
        register.clickContinue();
        login.enterPassword(password);
        login.clickSignInBtn();
    }
    @When("user enters email {string}")
    public void userEnterEmail(String email) {
        login.enterEmail(email);
        register.clickContinue();
    }
    @Then("user is prompted with invalid login error message")
    public void userLoginToTheSystemSuccessfully() {
        login.loginUnsuccessfulAssertion();
    }
}
