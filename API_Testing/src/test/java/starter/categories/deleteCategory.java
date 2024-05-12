package starter.categories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class deleteCategory {

    @Step("I send request to delete a category")
    public void deletePostById(int productID) {
        SerenityRest.given()
                .delete(getCategoryById.setAPIEndpointCategoriesById(31961));
    }
}
