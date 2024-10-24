package org.example;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.utility.RandomGeneration;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class UpdateUserTest {
    @Test
    void UpdateUserTest()
    {
        String name = RandomGeneration.generateRandomName();
        String email = RandomGeneration.generateRandomEmail();
        String b_token = "927e01eb8094f67d282dcdd4f9df99449ad4090aba133e34918dcda88086bb94";
        baseURI = "https://gorest.co.in";
        HashMap data = new HashMap();
        data.put("name", name);
        data.put("gender","male");
        given()
                .header("Authorization", "Bearer "+b_token)
                .body(data)
                .contentType("application/json")
                .when()
                .put("/public/v2/users/7488215")
                .then()
                .statusCode(200)
                .body("name",equalTo(name))
                .log().body()
        ;
    }
}
