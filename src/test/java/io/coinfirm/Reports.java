package io.coinfirm;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.PrintWriter;

import static com.jayway.restassured.RestAssured.given;

public class Reports {

    //@Test
    public void createNewAmlBasicReport() {
        Response response;

        response =
                given()
                        .contentType(ContentType.JSON)
                        .auth()
                        .oauth2("Bearer GHxLfIGzCmaOzO1FYZAP7INZ8NnfBnzA92W69rl570rUNh1uKvOYwkX4a2Otf7d5")
                        .when()
                        .get("https://test.coinfirm.io:81/v2/reports/aml/basic/1AuhjbLkuhbAfyCJopfUEbdGaktABdTavJ").
                        then().
                        extract().response(); // extract the response
                        response.print();
    }

    //@Test
    public void createNewAmlStandardReport() {
        Response response;

        response =
                given()
                        .contentType(ContentType.JSON)
                        .auth()
                        .oauth2("Bearer GHxLfIGzCmaOzO1FYZAP7INZ8NnfBnzA92W69rl570rUNh1uKvOYwkX4a2Otf7d5")
                        .when()
                        .get("https://test.coinfirm.io:81/v2/reports/aml/standard/1AuhjbLkuhbAfyCJopfUEbdGaktABdTavJ").
                        then().
                        extract().response(); // extract the response
        response.print();
    }

    @Test
    public void createNewAmlFullReport() {
        Response response;

        response =
                given()
                        .contentType(ContentType.JSON)
                        .auth()
                        .oauth2("Bearer GHxLfIGzCmaOzO1FYZAP7INZ8NnfBnzA92W69rl570rUNh1uKvOYwkX4a2Otf7d5")
                        .when()
                        .get("https://test.coinfirm.io:81/v2/reports/aml/full/1AuhjbLkuhbAfyCJopfUEbdGaktABdTavJ").
                        then().
                        extract().response(); // extract the response
        response.print();
    }

}

