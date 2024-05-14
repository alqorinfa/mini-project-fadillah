package starter.stepdefinitions.authentication;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.authentication.GetAllUser;

public class GetAllUsersStep {
    @Steps
    GetAllUser getAllUser;

    @Given("I set API endpoint for get all users")
    public void setAPIEndpointGetAllUsers() {
        getAllUser.setAPIEndpointGetAllUsers();
    }

    @When("I send request to get all users")
    public void requestToGetAllUsers() {
        getAllUser.sendRequestGetAllUsers();
    }

    @And("I receive data all users")
    public void receiveAllDataUsers() {
        getAllUser.receiveAllDataUsers();
    }
}
