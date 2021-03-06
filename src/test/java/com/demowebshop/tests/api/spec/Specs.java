package com.demowebshop.tests.api.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static com.demowebshop.configuration.env.AppConfiguration.config;
import static io.restassured.RestAssured.with;

public class Specs {

    public static RequestSpecification requestSpecification = with()
            .baseUri(config.apiUrl())
            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
            .log().all();

    public static ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();
}
