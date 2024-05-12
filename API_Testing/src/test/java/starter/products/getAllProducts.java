package starter.products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.Matchers.notNullValue;

public class getAllProducts {
    private static String url="https://altashop-api.fly.dev/api/products";

    @Step("I set API endpoint for get all products")
    public String setApiEndpoint() {
        return url;
    }

    @Step("I send request to get all products")
    public void sendGetRequestToAllProducts() {
        SerenityRest.given()
                .get(setApiEndpoint());
    }

    @Step("I receive status code 200")
    public void receiveStatusCode() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid data of all products")
    public void receiveValidDataAllProducts() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_PRODUCTS_SCHEMA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

        restAssuredThat(
                response -> {
                    response.body("data.ID", everyItem(notNullValue()));
                    response.body("data.Name", everyItem(notNullValue()));
                    response.body("data.Description", everyItem(notNullValue()));
                    response.body("data.Price", everyItem(notNullValue()));
                    response.body("data.Ratings", everyItem(notNullValue()));
                    response.body("data.Categories", everyItem(notNullValue()));
                }
        );
    }
}