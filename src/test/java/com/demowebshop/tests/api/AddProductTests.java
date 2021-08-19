package com.demowebshop.tests.api;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static com.demowebshop.tests.api.spec.Specs.*;
import static com.demowebshop.tests.api.spec.Specs.responseSpecification;
import static io.restassured.RestAssured.given;

// TODO: annotations
class AddProductTests {

    // TODO: annotations
    @Test
    void  addProductToCart() {
        int qtyItems = 2;

        Response response = given()
                .spec(requestSpecification)
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .body("addtocart_31.EnteredQuantity=" + qtyItems)
                .when()
                .post("/addproducttocart/details/31/1")
                .then()
                .assertThat()
                .statusCode(200)
                .spec(responseSpecification)
                .extract()
                .response();

     response.getBody();

    }
}
