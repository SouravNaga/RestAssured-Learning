package org.example;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.utility.RandomGeneration;

import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class CreateUserTest {
    @Test
    void createuser()
    {
        String name = RandomGeneration.generateRandomName();
        String email = RandomGeneration.generateRandomEmail();
        String b_token = "927e01eb8094f67d282dcdd4f9df99449ad4090aba133e34918dcda88086bb94";
        HashMap data = new HashMap();
        data.put("name", name);
        data.put("gender","male");
        data.put("email",email);
        data.put("status","active");

        RestAssured.baseURI = "https://gorest.co.in";

        given()
                .header("Authorization", "Bearer "+b_token)
                .contentType("application/json")
                .body(data)
                .when()
                .post("/public/v2/users")
                .then()
                .statusCode(201)
                .log().all()
                .body("gender",equalTo("male"))

        ;
    }
}
