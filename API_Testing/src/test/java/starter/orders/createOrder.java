package starter.orders;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONArray;
import org.json.JSONObject;
import starter.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class createOrder {
    private static String url="https://altashop-api.fly.dev/api/orders";
    String token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

    @Step("I set API endpoint for all order")
    public static String setAPIEndpointAllOrder() {
        return url;
    }

    @Step("I send request to create order with valid inputs")
    public void createOrderWithValidInputs() {
        JSONArray jsonArray = new JSONArray();

        JSONObject orderObject = new JSONObject();
        orderObject.put("product_id", 88700);
        orderObject.put("quantity", 1);

        jsonArray.put(orderObject);

        SerenityRest.given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(jsonArray.toString()) // Menggunakan jsonArray.toString()
                .post(setAPIEndpointAllOrder());
    }

    @Step("I receive the order data")
    public void receiveCreatedOrderData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_ORDER_WITH_VALID_INPUTS);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
        restAssuredThat(response -> response.body("data", notNullValue())); }

    @Step("I send request to create order with invalid ID")
    public void createOrderWithInvalidID() {
        JSONArray jsonArray = new JSONArray();

        JSONObject orderObject = new JSONObject();
        orderObject.put("product_id", "a");
        orderObject.put("quantity", 1);

        jsonArray.put(orderObject);

        SerenityRest.given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(jsonArray.toString()) // Menggunakan jsonArray.toString()
                .post(setAPIEndpointAllOrder());
    }

    @Step("I send request to create order with no quantity")
    public void createOrderWithNoQuantity() {
        JSONArray jsonArray = new JSONArray();

        JSONObject orderObject = new JSONObject();
        orderObject.put("product_id", 88700);
        orderObject.put("quantity", 0);

        jsonArray.put(orderObject);

        SerenityRest.given()
                .header("Content-type", "application/json")
                .header("Authorization", "Bearer " + token)
                .body(jsonArray.toString()) // Menggunakan jsonArray.toString()
                .post(setAPIEndpointAllOrder());
    }

    @Step("I got invalid ID error message ")
    public void gotInvalidIDErrorMessage(String message) {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.ERROR_INVALID_ID);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
        restAssuredThat(response -> {
            response.body("error", equalTo(message));
        });
    }

}
