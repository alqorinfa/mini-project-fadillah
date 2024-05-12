package starter.authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import starter.JsonSchemaHelper;
import starter.utils.JsonSchema;

import java.util.UUID;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class register {
    private static String url="https://altashop-api.fly.dev/api/auth/register";
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";
    String email = "user" + UUID.randomUUID().toString().substring(0, 3) + "@example.com";
    String password = UUID.randomUUID().toString().substring(0, 3).replace("-", "");
    String fullname = "User " + UUID.randomUUID().toString().substring(0, 3);

    @Step("I set API endpoint for register")
    public static String setAPIEndpointRegister() {
        return url;
    }

    @Step("I send request to register with valid inputs")
    public void RegisterWithValidInputs() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", email);
        requestBody.put("password", password);
        requestBody.put("fullname", fullname);

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .header("Authorization", "Bearer " + token)
                .post(setAPIEndpointRegister());
    }

    @Step("I receive valid data of account")
    public void receiveValidDataofAccount() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_USERS);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
        restAssuredThat(response -> response.body("data", notNullValue()));
    }

    @Step("I send request to register with invalid email")
    public void RegisterWithInvalidEmail() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "youyoumailcom");
        requestBody.put("password", "magnetic");
        requestBody.put("fullname", "illitt");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .header("Authorization", "Bearer " + token)
                .post(setAPIEndpointRegister());
    }

    @Step("I receive error message 'ERROR: invalid email'")
    public void errorMessageInvalidEmail(String message) {
        restAssuredThat(response -> {
            response.body("error", equalTo(message));
        });
    }

    @Step("I send request to register with empty inputs")
    public void RegisterWithEmptyInputs() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "");
        requestBody.put("password","");
        requestBody.put("fullname", "");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .header("Authorization", "Bearer " + token)
                .post(setAPIEndpointRegister());
    }

}
