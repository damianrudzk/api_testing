package io.coinfirm;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static com.jayway.restassured.RestAssured.given;

public class User {

    //@Test
    public void listOfUsers() {
                given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2("Bearer GHxLfIGzCmaOzO1FYZAP7INZ8NnfBnzA92W69rl570rUNh1uKvOYwkX4a2Otf7d5")

                .when()
                .get("https://test.coinfirm.io:81/v2/users")

                .then()
                .statusCode(200);

    }

    //@Test
    public void retriveProfileUserPositive() {
                given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2("Bearer GHxLfIGzCmaOzO1FYZAP7INZ8NnfBnzA92W69rl570rUNh1uKvOYwkX4a2Otf7d5")

                .when()
                .get("https://test.coinfirm.io:81/v2/users/e3cdd4e3-3c95-422f-ba7d-b1dfca29cf72")

                .then()
                .statusCode(200);
    }

    //@Test
    public void retriveProfileUserNegative() {
        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2("Bearer GHxLfIGzCmaOzO1FYZAP7INZ8NnfBnzA92W69rl570rUNh1uKvOYwkX4a2Otf7d5")

                .when()
                .get("https://test.coinfirm.io:81/v2/users/e3cdd4e3-3c95-422f-ba7d-b1dfca29cf72X")

                .then()
                .statusCode(404);


    }

    @Test
    public void editUserProfile() {
        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2("Bearer GHxLfIGzCmaOzO1FYZAP7INZ8NnfBnzA92W69rl570rUNh1uKvOYwkX4a2Otf7d5")
                .body("{\n" +
                        "  \"email\": \"john.doe@mail.com\",\n" +
                        "  \"active\": 0,\n" +
                        "  \"level\": 101,\n" +
                        "  \"public\": 1,\n" +
                        "  \"verified\": 0,\n" +
                        "  \"type\": \"individual\",\n" +
                        "  \"name\": \"Joe\",\n" +
                        "  \"surname\": \"Doe\",\n" +
                        "  \"company_name\": \"Coinfirm\",\n" +
                        "  \"phone\": \"+48557668900\",\n" +
                        "  \"website\": \"http://google.pl/\",\n" +
                        "  \"country\": \"Poland\",\n" +
                        "  \"city\": \"Warsaw\",\n" +
                        "  \"street\": \"Burakowska\",\n" +
                        "  \"post_code\": \"30-015 Warsaw\",\n" +
                        "  \"tax_id\": \"6982dj0okn381\",\n" +
                        "  \"company_id\": \"ksoi87jamo02\",\n" +
                        "  \"personal_id\": \"osd8i82w30\",\n" +
                        "  \"description\": \"My personal account\",\n" +
                        "  \"avatar\": \"/upload/avatar1.png\",\n" +
                        "  \"facebook\": \"http://facebook.com/asd\",\n" +
                        "  \"twitter\": \"http://twitter.com/asd\",\n" +
                        "  \"linkedin\": \"http://linkedin.com/asd\",\n" +
                        "  \"balance\": 100\n" +
                        "}")

                .when()
                .patch("https://test.coinfirm.io:81/v2/users/e3cdd4e3-3c95-422f-ba7d-b1dfca29cf72X")

                .then()
                .statusCode(200);
    }

    //@Test
    public void replaceUserProfile() {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer GHxLfIGzCmaOzO1FYZAP7INZ8NnfBnzA92W69rl570rUNh1uKvOYwkX4a2Otf7d5").and().header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"email\": \"damian.rudzki@coinfirm.io\",\n" +
                        "  \"public\": 1,\n" +
                        "  \"type\": \"individual\",\n" +
                        "  \"name\": \"Joe\",\n" +
                        "  \"surname\": \"Doe\",\n" +
                        "  \"company_name\": \"Coinfirm\",\n" +
                        "  \"phone\": \"+48557668900\",\n" +
                        "  \"website\": \"http://google.pl/\",\n" +
                        "  \"country\": \"Poland\",\n" +
                        "  \"city\": \"Warsaw\",\n" +
                        "  \"street\": \"Burakowska\",\n" +
                        "  \"post_code\": \"30-015 Warsaw\",\n" +
                        "  \"tax_id\": \"6982dj0okn381\",\n" +
                        "  \"company_id\": \"ksoi87jamo02\",\n" +
                        "  \"personal_id\": \"osd8i82w30\",\n" +
                        "  \"description\": \"My personal account\",\n" +
                        "  \"avatar\": \"/upload/avatar1.png\",\n" +
                        "  \"facebook\": \"http://facebook.com/asd\",\n" +
                        "  \"twitter\": \"http://twitter.com/asd\",\n" +
                        "  \"linkedin\": \"http://linkedin.com/asd\"\n" +
                        "}")

                .when()
                .get("https://test.coinfirm.io:81/v2/users/me")

                .then()
                .statusCode(200);
    }

    //@Test
    public void deleteUserProfile() {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer wptbYDnpIC9yw0Wv0EIAOMe0rNUzXQJZJn0FNnuDvipm8wot0yEGFn3yQAaM4u1i").and().header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"email\": \"damian.rudzki@coinfirm.io\",\n" +
                        "  \"public\": 1,\n" +
                        "  \"type\": \"individual\",\n" +
                        "  \"name\": \"Joe\",\n" +
                        "  \"surname\": \"Doe\",\n" +
                        "  \"company_name\": \"Coinfirm\",\n" +
                        "  \"phone\": \"+48557668900\",\n" +
                        "  \"website\": \"http://google.pl/\",\n" +
                        "  \"country\": \"Poland\",\n" +
                        "  \"city\": \"Warsaw\",\n" +
                        "  \"street\": \"Burakowska\",\n" +
                        "  \"post_code\": \"30-015 Warsaw\",\n" +
                        "  \"tax_id\": \"6982dj0okn381\",\n" +
                        "  \"company_id\": \"ksoi87jamo02\",\n" +
                        "  \"personal_id\": \"osd8i82w30\",\n" +
                        "  \"description\": \"My personal account\",\n" +
                        "  \"avatar\": \"/upload/avatar1.png\",\n" +
                        "  \"facebook\": \"http://facebook.com/asd\",\n" +
                        "  \"twitter\": \"http://twitter.com/asd\",\n" +
                        "  \"linkedin\": \"http://linkedin.com/asd\"\n" +
                        "}")
                .when()
                .delete("https://test.coinfirm.io:81/v2/users/me")

                .then()
                .statusCode(200);
    }

    //@Test
    public void changeUserProfilePassword() {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer GHxLfIGzCmaOzO1FYZAP7INZ8NnfBnzA92W69rl570rUNh1uKvOYwkX4a2Otf7d5").and().header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"current_password\": \"Coinfirm09!\",\n" +
                        "  \"password\": \"Coinfirm08!\"\n" +
                        "}")
                .when()
                .put("https://test.coinfirm.io:81/v2/users/me/password")

                .then()
                .statusCode(200);
    }
}
