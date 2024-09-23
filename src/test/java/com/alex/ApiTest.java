package com.alex;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class ApiTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
        RestAssured.config = RestAssured.config().encoderConfig(removeContentTypeCharset());
    }

    @Test
    public void testGetPostman() {
        given()
                .queryParam("foo1", "bar1")
                .queryParam("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                //.log().all()  // если нужны логи для проверки
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.accept", equalTo("*/*"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));

    }

    @Test
    public void testPostRequest() {
        String requestBody = "\"test\": \"value\"";

        given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                //.log().all()  // если нужны логи для проверки
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("\"test\": \"value\""))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.content-type", equalTo("application/json"))
                .body("headers.accept-encoding", containsString("gzip"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test  //Выдает ошибку 500
    public void testPostFormData() {
        given()
                .log().all()
                .contentType(ContentType.URLENC)
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when()
                .post("/post")
                .then()
                .log().all()
                .statusCode(200)
                .body("form.foo1", equalTo("bar1"))
                .body("form.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-type", equalTo("application/x-www-form-urlencoded"))
                .body("url", equalTo("https://postman-echo.com/post"));
    }

    @Test
    public void testPutRequest() {
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .body(requestBody)
                .when()
                .log().all()
                .put("/put")
                .then()
                .log().all()  // если нужны логи для проверки
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-type", equalTo("text/plain"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", containsString("gzip"))
                .body("url", equalTo("https://postman-echo.com/put"));
    }
    @Test
    public void testPatchRequest(){
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                //.log().all()  // если нужны логи для проверки
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-type", equalTo("text/plain"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", containsString("gzip"))
                .body("url", equalTo("https://postman-echo.com/patch"));
    }
    @Test
    public void testDeleteRequest(){
        String requestBody = "This is expected to be sent back as part of response body.";

        given()
                .body(requestBody)
                .when()
                .delete("/delete")
                .then()
                //.log().all()  // если нужны логи для проверки
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("This is expected to be sent back as part of response body."))
                .body("headers.x-forwarded-proto", equalTo("https"))
                .body("headers.content-length", equalTo("58"))
                .body("headers.x-forwarded-port", equalTo("443"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("headers.content-type", equalTo("text/plain"))
                .body("headers.accept", equalTo("*/*"))
                .body("headers.accept-encoding", containsString("gzip"))
                .body("url", equalTo("https://postman-echo.com/delete"));
    }

    private static EncoderConfig removeContentTypeCharset() {
        return EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false);
    }
}