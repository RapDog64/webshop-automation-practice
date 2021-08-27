package com.demowebshop.service;

import com.demowebshop.tests.api.spec.Specs;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static com.demowebshop.configuration.filters.AllureCustomFilter.allureLogFilter;
import static io.restassured.RestAssured.given;

public class Authorization {

    @Step("Log in as a user with '{email}' and '{password}'")
    public Response loginViaApi(String email, String password) {
        return given()
                .filter(allureLogFilter().withCustomTemplate())
                .spec(Specs.requestSpecification)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .formParam("Email", email)
                .formParam("Password", password)
                .when()
                .post("/login")
                .then()
                .extract().response();
    }
}
