package starter.stepdefinitions.category;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.categories.getCategoryById;

public class getCategoryByIdStep {
    @Steps
    getCategoryById getCategoryById;

    @Given("I set API endpoint for get category by id")
    public void SetAPIEndpointForACategory() {
        getCategoryById.setAPIEndpointCategoriesById(31978);
    }

    @When("I send request to get a category")
    public void getCategory() {
        getCategoryById.sendRequestGetCategory();
    }

    @And("I receive valid data of the category")
    public void receiveValidDataCategory() {
        getCategoryById.receiveValidData();
    }

    @When("I send request to get a category by unexisted id")
    public void getInvalidCategory() {
        getCategoryById.sendRequestGetInvalidCategory();
    }

    @And("I receive error message unexisted category {string}")
    public void receiveErrorMessageUnexistedCategory(String message) {
        getCategoryById.receiveErrorMessageUnexistedCategory("record not found");
    }
}
