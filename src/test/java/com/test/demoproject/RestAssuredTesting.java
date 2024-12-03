package com.test.demoproject;

import com.github.javafaker.Faker;
import com.main.demoproject.restassuredapitesting.endpoints.UserEndPoints;
import com.main.demoproject.restassuredapitesting.payload.Users;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RestAssuredTesting {
    Faker faker;
    Users usersPayload;
    @BeforeMethod
    public void testDataSetup()
    {
        faker = new Faker();
        usersPayload = new Users();
        usersPayload.setName(faker.name().firstName());
        usersPayload.setJob(faker.job().title());
    }

    @Test
    public void createUserTest()
    {
        Response response = UserEndPoints.createUser(usersPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),201);
    }
}
