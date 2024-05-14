package starter.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.jupiter.api.Assertions;
import starter.pages.EditPage;
import starter.pages.MainPage;

public class EditBookStep {
    @Steps
    MainPage mainPage;
    EditPage editPage;

    @When("I click edit icon")
    public void clickEditIcon(){
        mainPage.clickEditIcon();
        Assertions.assertTrue(editPage.validateOnEditPage());
    }

    @And("I input valid title")
    public void inputValidTitle() {
        editPage.inputValidTitle("Bentala Sella");
    }

    @And("I input valid author")
    public void inputValidAuthor() {
        editPage.inputAuthor("Akaigita");
    }

    @And("I input valid year")
    public void inputValidYear() {
        editPage.inputYear(2023);
    }
    @And("I click edit book button")
    public void clickEditBookButton() {
        editPage.clickEditButton();
    }

    @Then("the new detail is showed")
    public void newDetailIsShowed() {
        editPage.newDetailIsShowed();
    }

    @And("I input invalid year")
    public void inputInvalidYear() {
        editPage.inputYear(0000);
    }

    @Then("systems show error message {string}")
    public void errorMessageEditBook(String message) {
        Assertions.assertTrue(editPage.errorMessageEditFailed());
        Assertions.assertTrue(editPage.validateEqualErrorMessage("Book edit failed"));
    }

    @When("I click delete icon")
    public void clickDeleteIcon() {
        mainPage.clickDeleteIcon();
    }

    @And("I click yes button")
    public void clickYesButton() {
        editPage.clickYesDeleteButton();
    }

    @Then("system shows success message {string}")
    public void showsSuccessMessage(String message) {
        Assertions.assertTrue(editPage.showsSuccessMessage());
        Assertions.assertTrue(editPage.validateEqualSuccessMessage(message));
    }

    }

