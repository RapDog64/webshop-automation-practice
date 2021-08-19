package com.demowebshop.service;

import com.demowebshop.model.User;
import com.demowebshop.tests.api.spec.Specs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Authorization {

    public Response loginViaApi(User user) {
        return given()
                .spec(Specs.requestSpecification)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("Email", user.getEmail())
                .formParam("Password", user.getPassword())
                .when()
                .post("/login")
                .then()
                .statusCode(302)
                .contentType("text/html; charset=utf-8")
                .extract().response();
    }
}
