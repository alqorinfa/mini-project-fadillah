package starter.products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import starter.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.notNullValue;

public class AssignRating {
    private static String url = "https://altashop-api.fly.dev/api/products/";
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";
    @Step("I set api endpoint to assign product by ID")
    public static String setApiEndpointForProduct(int productID) {
        return url + productID +"/ratings";
    }

    @Step("I send request to assign rating for a product")
    public void sendRequestAssignRating() {

        JSONObject requestBody = new JSONObject();
        requestBody.put("Rating", 4);

        SerenityRest.given()
                .header("Content-type","application/json")
                .header("Authorization", "Bearer " + token)            .body(requestBody.toString())
                .post(AssignRating.setApiEndpointForProduct(88742));
    }

    @Step("I send request to assign rating for unexisted product")
    public void sendRequestAssignRatingUnexistedProduct() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("Rating", 4);

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .header("Authorization", "Bearer " + token)
                .post(AssignRating.setApiEndpointForProduct(887));
    }

    @Step("I send request to get a product rating")
    public void sendRequestToGetProductRating() {
        SerenityRest.given()
                .get(setApiEndpointForProduct(88742));
    }

    @Step("I get data of product with rating")
    public void getDataProductWithRating() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.VALID_RATING_DATA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }
    @Step("I get data of product rating")
    public void getValidDataProductRating() {
        restAssuredThat(response -> response.body("'data'", notNullValue()));
    }

}
