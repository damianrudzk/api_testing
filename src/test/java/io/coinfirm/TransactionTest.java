package io.coinfirm;

import com.jayway.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static com.jayway.restassured.RestAssured.given;

public class TransactionTest {

    @Test
    public void retrieveTransactionToken() {
        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2("Bearer GHxLfIGzCmaOzO1FYZAP7INZ8NnfBnzA92W69rl570rUNh1uKvOYwkX4a2Otf7d5")

                .when()
                .get("https://test.coinfirm.io:81/v2/transactions/credit-card/key")

                .then()
                .statusCode(200);
    }
}
