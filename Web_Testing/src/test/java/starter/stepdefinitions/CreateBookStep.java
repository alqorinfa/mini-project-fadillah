package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.CreatePage;

public class CreateBookStep {
    @Steps
    CreatePage createPage;

    @When("I click plus button")
    public void clickPlusButton() {
        createPage.clickPlusButton();
    }

    @And("I click save book button")
    public void clickSaveButton() {
        createPage.clickSaveButton();
    }

    @Then("system shows success create message {string}")
    public void showsSuccessCreateMessage(String message) {
        Assertions.assertTrue(createPage.showsSuccessCreateMessage());
        Assertions.assertTrue(createPage.validateSuccessCreateMessage(message));
    }

    @Then("systems show error create message {string}")
    public void showsErrorCreateMessage(String message) {
        Assertions.assertTrue(createPage.showsErrorCreateMessage());
        Assertions.assertTrue(createPage.validateErrorCreateMessage(message));
    }
}
