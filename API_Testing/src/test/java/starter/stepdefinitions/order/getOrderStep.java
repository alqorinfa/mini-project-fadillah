package starter.stepdefinitions.order;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.orders.getOrder;

public class getOrderStep {
    @Steps
    getOrder getOrder;

    @When("I send request to get all order")
    public void sendRequestToGetAllOrder() {
        getOrder.sendRequestToGetAllOrder();
    }

    @And("I receive data of all order")
    public void receiveDataAllOrder() {
        getOrder.receiveDataAllOrder();
    }

}
