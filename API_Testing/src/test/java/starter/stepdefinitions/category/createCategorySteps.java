package starter.stepdefinitions.category;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.categories.createCategory;

public class createCategorySteps {
    @Steps
    createCategory createCategory;

    @When("I send request to create a new category")
    public void createNewCategory() {
        createCategory.createNewCategory();
    }

    @And("I receive valid data of new category")
    public void receiveValidDataNewCategory() {
        createCategory.receiveValidDataNewCategory();
    }

    @When("I send request to create a new category with empty inputs")
    public void createNewCategoryWithEmptyInputs() {
        createCategory.createNewCategoryWithEmptyInputs();
    }

    @Then("I receive status code 500")
    public void receiveStatusCode500() {
        createCategory.errorCode500();
    }

    @And("I receive error message about empty inputs")
    public void receiveErrorMessageEmptyInputs() { createCategory.receiveErrorMessageEmptyInputs();}

}
