package org.example.stepDefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.RegisterPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class S01_RegisterStep {

    RegisterPage register = new RegisterPage();

    @Given("user go to register page")
    public void userGoRegisterPage() {
        register.registrationPage();
    }

    @When("user Enter his name")
    public void userEnterHisName(String name) {
        register.enterName(name);
    }

    @And("user Enter email")
    public void userEnter(String email) {
        register.enterEmail(email);
    }

    @And("user Enter password and confirmed this password")
    public void userEnterPassword(String pass) {
        register.enterPassword(pass);
        register.reEnterPassword(pass);
    }

    @And("user cick on Continue")
    public void userCickOnContinue() {
        register.clickContinue();
    }

    @And("user Verify info")
    public void userVerifyInfo() throws InterruptedException {
        register.clickSolvePuzzle();
    }
}
