package com.demowebshop.service;

import io.restassured.response.Response;

import static com.demowebshop.configuration.filters.AllureCustomFilter.allureLogFilter;
import static com.demowebshop.tests.api.spec.Specs.requestSpecification;
import static com.demowebshop.tests.api.spec.Specs.responseSpecification;
import static io.restassured.RestAssured.given;

public class ProductService {

    public Response addProductViaApi(int qtyItems) {
        return given()
                .filter(allureLogFilter().withCustomTemplate())
                .spec(requestSpecification)
                .body("addtocart_31.EnteredQuantity=" + qtyItems)
                .when()
                .post("/addproducttocart/details/31/1")
                .then()
                .assertThat()
                .spec(responseSpecification)
                .statusCode(200)
                .extract()
                .response();
    }
}
