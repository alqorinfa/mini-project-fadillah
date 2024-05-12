package starter.stepdefinitions.category;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.categories.getCategory;

public class getCategoryStep {
    @Steps
    getCategory getCategory;

    @Given("I set API endpoint for get all categories")
    public void setAPIEndpointAllCategories() {
        getCategory.setAPIEndpointCategories();
    }

    @When("I send request to get all categories")
    public void getAllCategories() {
        getCategory.sendRequestGetAllCategories();
    }

    @And("I receive all data of categories")
    public void receiveAllCategoriesData() {getCategory.receiveAllDataCategories();}
}
