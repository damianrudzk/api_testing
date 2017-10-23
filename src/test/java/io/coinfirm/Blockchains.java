package io.coinfirm;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.jupiter.api.Test;
import static com.jayway.restassured.RestAssured.given;

public class Blockchains {
    public static Response response;
    public static String jsonAsString;

    @Test
    public void retrieveBtcBlockchainHeight() {
        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2("Bearer OCCYCRaMHAPx6T7LlXDb8rvHHvHQNGv2AOjYVzX32jEOuqv8pAfBRqbff4MGezeT")

                .when()
                .get("https://api.coinfirm.io/v2/blockchains/block-height/BTC")

                .then()
                .statusCode(200);

    }

    @Test
    public void retrieveDashBlockchainHeight() {
        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2("Bearer OCCYCRaMHAPx6T7LlXDb8rvHHvHQNGv2AOjYVzX32jEOuqv8pAfBRqbff4MGezeT")

                .when()
                .get("https://api.coinfirm.io/v2/blockchains/block-height/BTC")

                .then()
                .statusCode(200);
    }
}
