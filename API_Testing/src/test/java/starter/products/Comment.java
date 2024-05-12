package starter.products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import org.json.JSONObject;
import starter.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Comment {
    private static String url = "https://altashop-api.fly.dev/api/products/";
    String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcnN0bmFtZSBMYXN0bmFtZSIsIkVtYWlsIjoic29tZW9uZUBtYWlsLmNvbSJ9.bGpZNDg6YHtKlTFw7_yuyn3SAICmfvdIV1yX7mIKrTw";
    @Step("I set api endpoint to add comment product by ID")
    public static String setApiEndpointForProduct(int productID) {
        return url + productID +"/comments";
    }

    @Step("I send request to post a comment")
    public void postComment() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("Content", "the games are great including Gran Turismo 7 but sadly GT4 is much better");

        SerenityRest.given()
                .header("Content-type","application/json")
                .header("Authorization", "Bearer " + token)
                .body(requestBody.toString())
                .post(Comment.setApiEndpointForProduct(88742));
    }

    @Step("I send request to get a comment")
    public void getComment() {
        SerenityRest.given()
                .get(setApiEndpointForProduct(88742));
    }

    @Step("")
    public void receiveSingleValidDataComment() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.VALID_SINGLE_COMMENT_DATA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I receive a valid data of comment")
    public void receiveValidDataComment() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.VALID_COMMENT_DATA);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
