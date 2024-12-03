package com.main.demoproject.restassuredapitesting.endpoints;

import com.main.demoproject.restassuredapitesting.payload.Users;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserEndPoints {

    public static Response createUser(Users payload)
    {
        Response response =given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .body(payload)
                .when()
                .post(Routes.postUrl);

        return response;
    }
}
