package starter.pages;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class mainPage extends PageObject {
    private By tableButton() {
        return By.xpath("//*[@id=\"root\"]/div/div[1]/button[1]");
    }
    private By cardButton(){
        return By.xpath("//*[@id=\"root\"]/div/div[1]/button[2]");
    }
    private By detailIcon(){
        return By.xpath("//*[@id=\"root\"]/div/table/tbody/tr[1]/td[5]/div/a[1]");
    }

    private By title() {
        return By.xpath("//*[@id=\"root\"]/div/div[2]/h1");
    }

    private By table() {
        return By.xpath("//*[@id=\"root\"]/div/table");
    }

    private By card() {
        return By.xpath("//*[@id=\"root\"]/div/div[3]/div[1]/h4");
    }

    private By detailBook() {
        return By.xpath("//*[@id=\"root\"]/div/div[2]/div[1]/span[1]");
    }

    private By editIcon() { return By.xpath("//*[@id=\"root\"]/div/table/tbody/tr[4]/td[5]/div/a[2]");}

    private By deleteIcon() {
        return By.xpath("//*[@id=\"root\"]/div/table/tbody/tr[8]/td[5]/div/a[3]");
    }

    @Step("I am on the main page")
    public boolean validateOnMainPage() {
        return $(title()).isDisplayed();
    }

    @Step("I click table button")
    public void clickTableButton() {
        $(tableButton()).click();
    }

    @Step("I see books list by table")
    public void tableBookList(){
        $(table()).isDisplayed();
    }

    @Step("I click card button")
    public void clickCardButton() {
        $(cardButton()).click();
    }

    @Step("I see books list by card")
    public void cardBookList() {
        $(card()).isDisplayed();
    }

    @Step("I click detail icon")
    public void clickDetailIcon() {
        $(detailIcon()).click();
    }

    @Step("I see a detail of book")
    public void seeDetailBook() {
        $(detailBook()).isDisplayed();
    }

    @Step("I click edit icon")
    public void clickEditIcon() {
        $(editIcon()).click();
    }

    @Step("I click delete icon")
    public void clickDeleteIcon() {
        $(deleteIcon()).click();
    }

}
