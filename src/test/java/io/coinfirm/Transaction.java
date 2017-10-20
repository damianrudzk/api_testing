package io.coinfirm;

import com.jayway.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static com.jayway.restassured.RestAssured.given;

public class Transaction {

    @Test
    public void retrieveTransactionToken() {
        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2("Bearer OCCYCRaMHAPx6T7LlXDb8rvHHvHQNGv2AOjYVzX32jEOuqv8pAfBRqbff4MGezeT")

                .when()
                .get("http://api.coinfirm.io/v2/transactions/credit-card/key")

                .then()
                .statusCode(200);
    }
}
