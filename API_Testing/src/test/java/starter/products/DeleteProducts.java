package starter.products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.isEmptyOrNullString;

public class DeleteProducts {
    private static String url = "https://altashop-api.fly.dev/api/products/";

    @Step("I set api endpoint to get product by ID")
    public String setApiEndpointForProduct(int productID) {
        return url + productID;
    }
    @Step("I send delete request to a product")
    public void deletePostById(int productID) {
            SerenityRest.given()
                    .delete(setApiEndpointForProduct(productID));
    }

    @Step("I receive empty data")
    public void receiveEmptyData() {
        restAssuredThat(response -> response.body("'data'", isEmptyOrNullString()));
    }

}
