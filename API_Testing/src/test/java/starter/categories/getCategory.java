package starter.categories;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class getCategory {
    private static String url="https://altashop-api.fly.dev/api/categories";
    @Step("I set API endpoint for get all categories")
    public static String setAPIEndpointCategories() {
        return url;
    }

    @Step("I send request to get all categories")
    public void sendRequestGetAllCategories(){
        SerenityRest.given()
                .get(setAPIEndpointCategories());
    }

    @Step("I receive all data of categories")
    public void receiveAllDataCategories() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_CATEGORIES);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

}
