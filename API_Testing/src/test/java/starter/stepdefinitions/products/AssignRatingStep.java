package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.products.AssignRating;

public class AssignRatingStep {
    @Steps
    AssignRating assignRating;

    @When("I send request to assign rating for a product")
    public void sendRequestAssignRating() {
        assignRating.sendRequestAssignRating();
    }

    @When("I send request to assign rating for unexisted product")
    public void sendRequestAssignRatingUnexistedProduct() {
        assignRating.sendRequestAssignRatingUnexistedProduct();
    }

    @When("I send request to get a product rating")
    public void sendRequestToGetProductRating() {
        assignRating.sendRequestToGetProductRating();
    }

    @And("I get data of product with rating")
    public void getDataProductWithRating() { assignRating.getDataProductWithRating(); }
    @And("I get data of product rating")
    public void getValidDataProductRating() {
        assignRating.getValidDataProductRating();
    }
}
