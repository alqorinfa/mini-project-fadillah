package starter.pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class EditPage extends PageObject {
    private By onEditPage() {
        return By.xpath("//*[@id=\"root\"]/div/h1");
    }

    private By titleBook() {
        return By.xpath("//*[@id=\"title\"]");
    }

    private By author() {
        return By.xpath("//*[@id=\"author\"]");
    }

    private By year() {
        return By.xpath("//*[@id=\"publishYear\"]");
    }

    private By editButton() {
        return By.xpath("//*[@id=\"root\"]/div/div[2]/button");
    }

    private By newDetail() {
        return By.xpath("//*[@id=\"root\"]/div/h1");
    }

    private By errorEditBookMessage() {
        return By.xpath("//*[@id=\"root\"]/div[2]/div");
    }


    private By yesDeleteButton() {
        return By.xpath("//*[@id=\"root\"]/div/div[2]/button");
    }

    private By successfulMessage() {
        return By.xpath("//*[@id=\"notistack-snackbar\"]");
    }

    @Step
    public boolean validateOnEditPage() {
        return $(editButton()).isDisplayed();
    }

    @Step("I input title")
    public void inputValidTitle(String title) {
        $(titleBook()).type(title);
    }

    @Step("I input author")
    public void inputAuthor(String inputAuthor) {
        $(author()).type(inputAuthor);
    }

    @Step("I input year")
    public void inputYear(int inputYear){
        $(year()).type(Integer.toString(inputYear));
    }

    @Step("I click edit book button")
    public void clickEditButton() {
        $(editButton()).click();
    }

    @Step("the new detail is showed")
    public void newDetailIsShowed() {
        $(newDetail()).isDisplayed();
    }

    @Step("systems show error message 'Book edit failed'")
    public boolean errorMessageEditFailed() {
        return $(errorEditBookMessage()).isDisplayed();
    }

    @Step
    public boolean validateEqualErrorMessage(String message) {
        return $(errorEditBookMessage()).getText().equalsIgnoreCase(message);
    }

    @Step("I click yes button")
    public void clickYesDeleteButton() {
        $(yesDeleteButton()).click();
    }

    @Step("system shows success message 'book deleted successfully'")
    public boolean showsSuccessMessage() {
        return $(successfulMessage()).isDisplayed();
    }

    @Step
    public boolean validateEqualSuccessMessage(String message) {
        return $(successfulMessage()).getText().equalsIgnoreCase(message);
    }


}
