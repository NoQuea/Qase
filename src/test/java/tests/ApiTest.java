package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    @Test
    public void testApi(){
        given().
                header("Token", "41f47c8feeff80602ed60ca90b7a7bc32a2a26be").
                header("Content-Type","application/json").
                header("Accept","application/json").
                body("{'title' : 'BuildBuild', 'code' : '!!!!!!!!'}").
        when().
                post("https://api.qase.io/v1/project/").
        then().
                statusCode(400).
                body("errorMassage", equalTo("Data is invalid."));


    }
}
