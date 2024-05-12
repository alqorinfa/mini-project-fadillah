package starter.authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import starter.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

public class login {
    private static String url="https://altashop-api.fly.dev/api/auth/login";
    @Step("I set API endpoint for login")
    public static String setAPIEndpointLogin() {
        return url;
    }

    @Step("I login with valid credentials")
    public void loginWithValidCredentials() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "youyou@mail.com");
        requestBody.put("password", "magnetic");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointLogin());
    }

    @Step("I receive token")
    public void receiveToken(){
        restAssuredThat(response -> response.body("data", notNullValue()));
    }

    @Step("I login with invalid email")
    public void LoginWithInvalidEmail() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "youmailcom");
        requestBody.put("password", "magnetic");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointLogin());
    }

    @Step("I receive error message invalid email")
    public void receiveErrorMessageInvalidEmail(String message) {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.ERROR_RECORD_NOT_FOUND);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
        restAssuredThat(response -> {
            response.body("error", equalTo(message));
        });
    }

    @Step("I login with invalid Password")
    public void loginWithInvalidPassword() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "youyou@mail.com");
        requestBody.put("password", "magnetized");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointLogin());
    }

    @Step("I receive error message invalid password")
    public void receiveErrorMessageInvalidPassword(String message) {
        restAssuredThat(response -> {
            response.body("error", equalTo(message));
        });
    }
    @Step("I login with empty inputs")
    public void loginWithEmptyInputs() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "");
        requestBody.put("password", "");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointLogin());
    }

    @Step("I login with unregistered email")
    public void loginWithUnregisteredEmail() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "youu@mail.com");
        requestBody.put("password", "magnetic");

        SerenityRest.given()
                .header("Content-type","application/json")
                .body(requestBody.toString())
                .post(setAPIEndpointLogin());
    }
}
