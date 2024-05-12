package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.products.createProducts;

public class createProductsStep {
    @Steps
    createProducts createProducts;

    @When("I send request to create a new product")
    public void sendRequestCreateNewProduct() {
        createProducts.sendCreateProductRequest();
    }

    @And("I receive valid data of new product")
    public void receiveValidDataNewProduct() {
        createProducts.receiveValidDataNewProduct();
    }

    @When("I send request to create a new product with empty inputs")
    public void sendRequestEmptyInputs() {
        createProducts.sendCreateNewProductWithEmptyInputs();
    }

    @Then("I receive status code 400")
    public void receiveStatuscode400() {
        createProducts.receiveStatusCode400();
    }

    @And("I got empty error message {string}")
   public void gotErrorMessageEmptyInputs(String message) {
        createProducts.gotErrorMessageInvalidPrice("json: cannot unmarshal string into Go struct field ProductCreate.price of type uint");   }

    @When("I send request to create a new product with invalid price")
    public void createNewProductInvalidPrice() {
        createProducts.sendRequestCreateNewPostInvalidPrice();
    }

    @Then("I got invalid error message {string}")
    public void invalidPriceErrorMessage(String message) {
        createProducts.gotErrorMessageInvalidPrice("json: cannot unmarshal string into Go struct field ProductCreate.price of type uint"); }

}
