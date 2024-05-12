package starter.pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class createPage extends PageObject {
    private By onCreatePage() {return By.xpath("//*[@id=\"root\"]/div/h1");}

    private By plusButton() {return By.xpath("//*[@id=\"root\"]/div/div[2]/a");}

    private By saveBookButton() {return By.xpath("//*[@id=\"root\"]/div/div[2]/button");}

    private By errorCreateMessage() {return By.xpath("//*[@id=\"root\"]/div[2]");}

    private By successCreateMessage() {return By.xpath("//*[@id=\"notistack-snackbar\"]");}

    @Step
    public void clickPlusButton() {
        $(plusButton()).click();
        $(onCreatePage()).isDisplayed();
    }

    @Step
    public void clickSaveButton() {
        $(saveBookButton()).click();
    }

    @Step
    public boolean showsSuccessCreateMessage() {
        return $(successCreateMessage()).isDisplayed();
    }

    @Step
    public boolean validateSuccessCreateMessage(String message) {
        return $(successCreateMessage()).getText().equalsIgnoreCase(message);
    }

    @Step
    public boolean showsErrorCreateMessage() {
        return $(errorCreateMessage()).isDisplayed();
    }

    @Step
    public boolean validateErrorCreateMessage(String message) {
        return $(errorCreateMessage()).getText().equalsIgnoreCase(message);
    }

}
