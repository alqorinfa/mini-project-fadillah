package starter.categories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class getCategoryById {
    private static String url="https://altashop-api.fly.dev/api/categories/";
    @Step("I set API endpoint for get category by id")
    public static String setAPIEndpointCategoriesById(int categoryId) {
        return url + categoryId;
    }

    @Step("I send request to get a category")
    public void sendRequestGetCategory() {
        SerenityRest.given()
                .get(setAPIEndpointCategoriesById(31978));
    }

    @Step("I receive valid data of the category")
    public void receiveValidData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_CATEGORY_BY_ID);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
        restAssuredThat(response -> response.body("data", notNullValue()));
    }

    @Step("I send request to get a category")
    public void sendRequestGetInvalidCategory() {
        SerenityRest.given()
                .get(setAPIEndpointCategoriesById(3197));
    }

    @Step("I receive error message unexisted category")
    public void receiveErrorMessageUnexistedCategory(String message) {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.ERROR_RECORD_NOT_FOUND);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
        restAssuredThat(response -> {
            response.body("error", equalTo(message));
        });
    }

}
