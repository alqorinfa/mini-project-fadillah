package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.products.DeleteProducts;

public class deleteProduct {
    @Steps
    DeleteProducts deleteProducts;

    @When("I send delete request to a product")
    public void sendDeleteRequest(){
        deleteProducts.deletePostById(88699);
    }

    @And("I receive empty data")
    public void receiveEmptyData() {
        deleteProducts.receiveEmptyData();
    }
}
