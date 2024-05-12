package starter.stepdefinitions.authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.authentication.register;

public class registerStep {
    @Steps
    register register;

    @Given("I set API endpoint for register")
    public void setAPIEndpointForRegister() {
        register.setAPIEndpointRegister();
    }

    @When("I send request to register with valid inputs")
    public void registerWithValidInputs() {
        register.RegisterWithValidInputs();
    }

    @And("I receive valid data of account")
    public void receiveValidDataAccount() {
        register.receiveValidDataofAccount();
    }

    @When("I send request to register with invalid email")
    public void registerWithInvalidEmail() {
        register.RegisterWithInvalidEmail();
    }

    @And("I receive error message {string}")
    public void errorMessageInvalidEmail(String message) {
        register.errorMessageInvalidEmail("ERROR: invalid email");
    }

    @When("I send request to register with empty inputs")
    public void registerWithEmptyInputs() {
        register.RegisterWithEmptyInputs();
    }

    @And("I receive error message empty email {string}")
    public void errorMessageEmptyEmailInputs(String message) {
        register.errorMessageInvalidEmail("email is required");
    }

}
