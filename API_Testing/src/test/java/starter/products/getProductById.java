package starter.products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class getProductById {
    private static String url = "https://altashop-api.fly.dev/api/products/";

    @Step("I set api endpoint to get product by ID")
    public String setApiEndpointForProduct(int productID) {
        return url + productID;
    }

    @Step("I send request to get product by ID")
    public void sendRequestByID(int productID) {
        SerenityRest.given()
                .get(setApiEndpointForProduct(productID));
    }

    @Step("I send request to get product by unexisted ID")
    public void sendRequestByUnexistedID(int productID) {
        SerenityRest.given()
                .get(setApiEndpointForProduct(productID));
    }

    @Step("I receive status code 404")
    public void receiveStatusCode404() {
        restAssuredThat(response -> response.statusCode(404));
    }

    @Step("I receive data product by ID")
    public void receiveDataProductByID() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCTS_BY_ID);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I receive error message unexisted product {string}")
    public void receiveErrorMessageUnexistedProduct(String message) {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.ERROR_RECORD_NOT_FOUND);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
        restAssuredThat(response -> {
            response.body("error", equalTo(message));
        });

    }
}

