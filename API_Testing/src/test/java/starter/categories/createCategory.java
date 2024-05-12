package starter.categories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import starter.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.notNullValue;

public class createCategory {

    @Step("I send request to create a new category")
    public void createNewCategory() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("Name", "gaming");
        requestBody.put("Description", "for gaming purposes");
        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(requestBody.toString())
                .post(getCategory.setAPIEndpointCategories());
    }

    @Step("I receive valid data of new category")
    public void receiveValidDataNewCategory() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_CATEGORY_BY_ID);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

        restAssuredThat(response -> response.body("data", notNullValue()));
    }

    @Step("I send request to create a new category with empty inputs")
    public void createNewCategoryWithEmptyInputs() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "");
        requestBody.put("description", "");
        SerenityRest.given()
                .header("Content-type", "application/json")
                .body(requestBody.toString())
                .post(getCategory.setAPIEndpointCategories());
    }

    @Step("I receive status code 500")
    public void errorCode500() {
        restAssuredThat(response -> response.statusCode(500));
    }

    @Step("I receive error message about empty inputs")
    public void receiveErrorMessageEmptyInputs() {
        restAssuredThat(response -> {
            response.body("error", notNullValue());});
    }


}
