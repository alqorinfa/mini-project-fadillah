package starter.products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONArray;
import org.json.JSONObject;
import starter.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;


public class createProducts {
    @Steps
    getAllProducts getAllProducts;

    @Step("I send request to create a new product")
    public void sendCreateProductRequest() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("Name", "Sony PS5");
        requestBody.put("Description", "play has no limits");
        requestBody.put("Price", 299);
        JSONArray categories = new JSONArray();
        categories.put(1);
        requestBody.put("Categories", categories);

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(getAllProducts.setApiEndpoint());
    }

    @Step("I receive valid data of new product")
    public void receiveValidDataNewProduct() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_PRODUCT_WITH_VALID_DATA);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I send request to create a new product with empty inputs")
    public void sendCreateNewProductWithEmptyInputs() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("Name", "");
        requestBody.put("Description", "");
        requestBody.put("Price", "");
        JSONArray categories = new JSONArray();
        requestBody.put("Categories", categories);

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(getAllProducts.setApiEndpoint());
    }

    @Step("I receive status code 400")
    public void receiveStatusCode400() {
        restAssuredThat(response -> response.statusCode(400));}

    @Step("I send request to create a new product with invalid price")
    public void sendRequestCreateNewPostInvalidPrice() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("Name", "Sony PS5");
        requestBody.put("Description", "play has no limits");
        requestBody.put("Price", "contoh");
        JSONArray categories = new JSONArray();
        categories.put(1);
        requestBody.put("Categories", categories);

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(getAllProducts.setApiEndpoint());
    }

    @Step("I got invalid error message {string}")
    public void gotErrorMessageInvalidPrice(String message) {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.ERROR_INVALID_PRICE);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
        restAssuredThat(response -> {
            response.body("error", equalTo(message));
        });

    }
}
