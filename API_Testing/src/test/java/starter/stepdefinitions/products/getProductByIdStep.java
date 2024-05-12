package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.products.getProductById;

public class getProductByIdStep {
    @Steps
    getProductById getProductById;


    @When("I send request to get product by ID")
    public void sendRequestGetProductByID() {
        getProductById.sendRequestByID(88722);
    }

    @When("I send request to get product by unexisted ID")
    public void sendRequestGetProductByUnexistedID() {
        getProductById.sendRequestByUnexistedID(8870);
    }

    @Then("I receive status code 404")
    public void receiveStatusCode404() {
        getProductById.receiveStatusCode404();
    }

    @And("I receive data product by ID")
    public void receiveDataProductByID() {getProductById.receiveDataProductByID();}

    @And("I receive error message unexisted product {string}")
    public void receiveErrorMessageUnexistedProduct(String message) {
        getProductById.receiveErrorMessageUnexistedProduct("record not found");
    }
}
