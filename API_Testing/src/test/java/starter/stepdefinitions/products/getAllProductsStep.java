package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.products.getAllProducts;

public class getAllProductsStep {

    @Steps
    getAllProducts getAllProducts;

    @Given("I set API endpoint for get all products")
    public void setApiEndpoints() {
        getAllProducts.setApiEndpoint();
    }

    @When("I send request to get all products")
    public void sendRequestGetAllProducts() {
        getAllProducts.sendGetRequestToAllProducts();
    }

    @Then("I receive status code 200")
    public void receiveStatusCode() {
        getAllProducts.receiveStatusCode();
    }

    @And("I receive valid data of all products")
    public void receiveValidDataAllProducts() {
        getAllProducts.receiveValidDataAllProducts();
    }




}
