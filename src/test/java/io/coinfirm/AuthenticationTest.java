package io.coinfirm;

import com.jayway.restassured.http.ContentType;
import org.junit.*;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

public class AuthenticationTest {

    @Test
    public void userRegistrationRestAssuredNegative() {
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
                //.body(containsString("UserTest already registered"))
                .statusCode(400);
    }

    //problem z danymi na testowej bazie
    @Test
    public void retriveAnUserToken() {
        given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer OCCYCRaMHAPx6T7LlXDb8rvHHvHQNGv2AOjYVzX32jEOuqv8pAfBRqbff4MGezeT").and().header("Content-Type", "application/json")

                .body("{\n" +
                        "   \"email\": \"damianbeat@gmail.com\",\n" +
                        "   \"password\": \"Coinfirm09!\"\n" +
                        "}")

                .when()
                .post("https://test.coinfirm.io:81/v2/auth/login")

                .then()
                .statusCode(200);
                //.body("token", equalTo("OCCYCRaMHAPx6T7LlXDb8rvHHvHQNGv2AOjYVzX32jEOuqv8pAfBRqbff4MGezeT"))

    }

    @Test
    public void verificationEmail() {
        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2("Bearer OCCYCRaMHAPx6T7LlXDb8rvHHvHQNGv2AOjYVzX32jEOuqv8pAfBRqbff4MGezeT")

                .when()
                .post("https://api.coinfirm.io/v2/auth/resend-verification-email")

                .then()
                .statusCode(200);
    }

    @Test
    public void userActivate() {
        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2("Bearer OCCYCRaMHAPx6T7LlXDb8rvHHvHQNGv2AOjYVzX32jEOuqv8pAfBRqbff4MGezeT")
                .body("{\n" +
                        "  \"key\": \"zPi1A43pQ69OySw/OI2W8Tin9B\"\n" +
                        "}")
                .when()
                .post("https://test.coinfirm.io:81/v2/auth/user-confirm")

                .then()
                .statusCode(404);
    }

    //do omówienia razem ze zmianą adresu
    //@Test
    public void initiateEmailChange() {
        given()
                .contentType(ContentType.JSON)
                .auth()
                .oauth2("Bearer OCCYCRaMHAPx6T7LlXDb8rvHHvHQNGv2AOjYVzX32jEOuqv8pAfBRqbff4MGezeT")
                .when()
                .post("https://api.coinfirm.io/v2/auth/email-change")
                .then()
                .statusCode(404);
    }

    //@Test
    public void userEmailChange() {
        given()
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .when()
                .post("https://test.coinfirm.io:81/v2/auth/email-change")

                .then()
                .statusCode(404);
    }


    //@Test
    public void initiatePasswordReset() {
        given()
                .contentType(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"email\": \"damian.rudzki@coinfirm.io\"\n" +
                        "}")
                .when()
                .post("http://test.coinfirm.io:81/v2/auth/password-reset")

                .then()
                .statusCode(204);
    }

    //@Test
    public void password_reset() {
        given()

                .body("{\n" +
                        "  \"email\": \"damian.rudzki@coinfirm.io\"\n" +
                        "}")
                .when()
                .post("http://test.coinfirm.io:81/v2/auth/password-reset")

                .then()
                .statusCode(204);
    }
}
