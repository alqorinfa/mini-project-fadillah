package starter.authentication;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class getAllUser {
    private static String url="https://altashop-api.fly.dev/api/auth/info";
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";

    @Step("I set API endpoint for get all users")
     public static String setAPIEndpointGetAllUsers() {
        return url;
    }

    @Step("I send request to get all users")
    public void sendRequestGetAllUsers() {
        SerenityRest.given()
                .header("Authorization", "Bearer " + token)
                .get(setAPIEndpointGetAllUsers());
    }

    @Step("I receive data all users")
    public void receiveAllDataUsers() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_USERS);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

        restAssuredThat(response -> response.body("data.ID", equalTo(31506)));
        restAssuredThat(response -> response.body("data.Fullname", equalTo("Firstname Lastname")));
        restAssuredThat(response -> response.body("data.Email", equalTo("someone@mail.com")));
        restAssuredThat(response -> response.body("data.Password", equalTo("123123")));
    }

}


