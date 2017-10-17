package io.coinfirm;

import com.jayway.restassured.http.ContentType;
import org.junit.*;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

public class Authentication {

    //@Test
    public void userRegistrationjava() {

        Client client = ClientBuilder.newClient();
        Entity payload = Entity.json("{  'email': 'damianbeat@gmail.com',  'password': '5h322{R9wp',  'name': 'Joe',  'surname': 'Doe'}");
        Response response = client.target("https://test.coinfirm.io:81/v2/auth/register")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(payload);

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + response.readEntity(String.class));
    }

    @Test
    public void userRegistrationRestAssured() {
        given()
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "\"email\": \"damianbeat@gmail.com\",\n" +
                        "\"password\": \"Test123!\"\n" +
                        "\"name\": \"Damian\"\n" +
                        "\"surname\": \"Tester\"\n" +
                        "}")

                .when()
                .post("https://test.coinfirm.io:81/v2/auth/register")

                .then()
                .statusCode(200);

    }

    //@Test
    public void retriveAnUserToken() {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "GHxLfIGzCmaOzO1FYZAP7INZ8NnfBnzA92W69rl570rUNh1uKvOYwkX4a2Otf7d5").and().header("Content-Type", "application/json")
                .body("{\n" +
                        "   \"email\": \"damian.rudzki@coinfirm.io\",\n" +
                        "   \"password\": \"Coinfirm09!\"\n" +
                        "}")

                .when()
                .post("https://test.coinfirm.io:81/v2/auth/login")

                .then()
                .body("token", equalTo("GHxLfIGzCmaOzO1FYZAP7INZ8NnfBnzA92W69rl570rUNh1uKvOYwkX4a2Otf7d5"));

    }

    //@Test
    public void verificationEmail() {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer GHxLfIGzCmaOzO1FYZAP7INZ8NnfBnzA92W69rl570rUNh1uKvOYwkX4a2Otf7d5").and().header("Content-Type", "application/json")


                .when()
                .post("https://test.coinfirm.io:81/v2/auth/resend-verification-email")

                .then()
                .statusCode(200);
    }

    //@Test
    public void userActivate() {
        given()
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"key\": \"zPi1A43pQ69OySw/OI2W8Tin9B\"\n" +
                        "}")
                .when()
                .post("https://test.coinfirm.io:81/v2/auth/user-confirm")

                .then()
                .statusCode(404);
    }

    //@Test
    public void userEmailChange() {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer GHxLfIGzCmaOzO1FYZAP7INZ8NnfBnzA92W69rl570rUNh1uKvOYwkX4a2Otf7d5").and().header("Content-Type", "application/json")

                .when()
                .post("https://test.coinfirm.io:81/v2/auth/email-change")

                .then()
                .statusCode(404);
    }


    //@Test
    public void password_reset() {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer GHxLfIGzCmaOzO1FYZAP7INZ8NnfBnzA92W69rl570rUNh1uKvOYwkX4a2Otf7d5").and().header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"email\": \"damian.rudzki@coinfirm.io\"\n" +
                        "}")
                .when()
                .post("http://test.coinfirm.io:81/v2/auth/password-reset")

                .then()
                .statusCode(204);
    }
}
