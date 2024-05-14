package starter.stepdefinitions.category;

import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.categories.DeleteCategory;

public class DeleteCategoryStep {
    @Steps
    DeleteCategory deleteCategory;

    @When("I send request to delete a category")
    public void deleteCategory() {
        deleteCategory.deletePostById(31961);
    }
}
