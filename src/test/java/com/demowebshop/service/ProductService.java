package com.demowebshop.service;

import com.demowebshop.tests.api.spec.Specs;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.responseSpecification;

public class ProductService {

    public Response addProductViaApi(int qtyItems) {
        return given()
                .spec(Specs.requestSpecification)
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
