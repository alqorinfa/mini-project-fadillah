package starter.stepdefinitions.products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.products.Comment;

public class CommentStep {
    @Steps
    Comment comment;

    @When("I send request to post a comment")
    public void postComment() {
        comment.postComment();
    }

    @When("I send request to get a comment")
    public void getComment() {
        comment.getComment();
    }

    @And("I receive a valid data of comment")
    public void receiveValidDataComment() {
        comment.receiveValidDataComment();
    }

    @And("I receive single valid data of comment")
    public void receiveSingleValidData() { comment.receiveSingleValidDataComment();}

}
