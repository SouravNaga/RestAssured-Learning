package org.example;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class GetUserTest {
    String b_token = "927e01eb8094f67d282dcdd4f9df99449ad4090aba133e34918dcda88086bb94";
    @Test(priority = 1)
    void getUserTest(){

        given()
                .header("Authorization", "Bearer "+b_token)
                .when()
                .get("https://gorest.co.in/public/v2/users")
                .then()
                .statusCode(200)
                .log().all()

        ;
    }

    @Test(priority=2)
    void getUserTest2()
    {
        RestAssured.baseURI = "https://gorest.co.in";
        Response res = RestAssured.given()
                .header("Authorization", "Bearer "+b_token)
                .when()
                .get("/public/v2/users")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .response();
        System.out.println(res.asString());
    }
}
