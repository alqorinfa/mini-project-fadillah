package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.pages.MainPage;

public class BookViewStep {
    @Steps
    MainPage mainPage;

    @Given("I am on the main page")
    public void onTheMainPage() {
        mainPage.openUrl("https://mini-book-store-fe.vercel.app/");
        mainPage.validateOnMainPage();
    }

    @When("I click table button")
    public void clickTableButton() {
        mainPage.clickTableButton();
    }

    @Then("I see books list by table")
    public void bookListByTable() {
        mainPage.tableBookList();
    }

    @When("I click card button")
    public void clickCardButton() {
        mainPage.clickCardButton();
    }

    @Then("I see books list by card")
    public void cardBookList() {
        mainPage.cardBookList();
    }

    @When("I click detail icon")
    public void clickDetailIcon() {
        mainPage.clickDetailIcon();
    }

    @Then("I see a detail of book")
    public void detailBook() {
        mainPage.seeDetailBook();
    }
}
