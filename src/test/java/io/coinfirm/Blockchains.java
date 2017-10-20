package io.coinfirm;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.After;
import org.junit.jupiter.api.Test;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

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
        response =
        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2("Bearer OCCYCRaMHAPx6T7LlXDb8rvHHvHQNGv2AOjYVzX32jEOuqv8pAfBRqbff4MGezeT")

                .when()
                .get("https://api.coinfirm.io/v2/blockchains/block-height/BTC")

                .then()
                .contentType(ContentType.JSON).  // check that the content type return from the API is JSON
                extract().response();
        jsonAsString = response.asString();
        response.print();
        System.out.println(jsonAsString);
        String test = "test";
        System.out.println(test);
    }
}
