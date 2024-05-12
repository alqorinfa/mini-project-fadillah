package starter.stepdefinitions.authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.authentication.login;

public class LoginStep {
    @Steps
    login login;

    @Given("I set API endpoint for login")
    public void setAPIEndpointForLogin() {
        login.setAPIEndpointLogin();
    }

    @When("I login with valid credentials")
    public void loginWithValidCredentials() {
        login.loginWithValidCredentials();
    }

    @And("I receive token")
    public void receiveToken() {
        login.receiveToken();
    }

    @When("I login with invalid email")
    public void loginWithInvalidEmail() {
        login.LoginWithInvalidEmail();
    }

    @When("I login with invalid password")
    public void loginWithInvalidPassword() {
        login.loginWithInvalidPassword();
    }

    @When("I login with empty inputs")
    public void loginWithEmptyInputs() {
        login.loginWithEmptyInputs();
    }

    @When("I login with unregistered email")
    public void loginWithUnregisteredEmail() {
       login.loginWithUnregisteredEmail();
    }

    @And("I receive error message invalid email {string}")
    public void receiveErrorMessageInvalidEmail(String message) {
        login.receiveErrorMessageInvalidEmail("record not found");
    }

    @And("I receive error message invalid password {string}")
    public void receiveErrorMessageInvalidPassword(String message) {
        login.receiveErrorMessageInvalidPassword("email or password is invalid");
    }

}
