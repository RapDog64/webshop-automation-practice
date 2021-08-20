package com.demowebshop.tests.api.spec;

import com.demowebshop.configuration.filters.AllureCustomFilter;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;

public class Specs {

    public static RequestSpecification requestSpecification = with()
            .baseUri("http://demowebshop.tricentis.com")
            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
            .filter(AllureCustomFilter.allureLogFilter().withCustomTemplate())
            .log().all();

    public static ResponseSpecification responseSpecification = new ResponseSpecBuilder()
            .log(LogDetail.ALL)
            .build();

}
