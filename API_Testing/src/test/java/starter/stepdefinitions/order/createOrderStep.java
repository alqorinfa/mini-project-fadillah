package starter.stepdefinitions.order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.orders.createOrder;

public class createOrderStep {
    @Steps
    createOrder createOrder;

    @Given("I set API endpoint for all order")
    public void setAPIEndpointForAllOrder(){
        createOrder.setAPIEndpointAllOrder();
    }

    @When("I send request to create order with valid inputs")
    public void createOrderWithValidInputs() {
        createOrder.createOrderWithValidInputs();
    }

    @And("I receive the order data")
    public void receiveOrderData() {
        createOrder.receiveCreatedOrderData();
    }

    @When("I send request to create order with invalid ID")
    public void createOrderWithInvalidID() {
        createOrder.createOrderWithInvalidID();
    }

    @When("I send request to create order with no quantity")
    public void createOrderWithNoQuantity() {
        createOrder.createOrderWithNoQuantity();
    }

    @And("I got invalid ID error message {string}")
    public void gotInvalidIDErrorMessage(String message) {
        createOrder.gotInvalidIDErrorMessage("json: cannot unmarshal string into Go struct field OrderCreate.product_id of type uint");
    }
}
