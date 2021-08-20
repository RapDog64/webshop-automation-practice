package com.demowebshop.tests.api;

import com.demowebshop.model.api.AddProductResponse;
import com.demowebshop.service.ProductService;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

// TODO: annotations
class AddProductTests {

    private ProductService productService = new ProductService();

    // TODO: annotations
    @Test
    void  addProductToCart() {
        int qtyItems = 2;

        Response response = productService.addProductViaApi(qtyItems);
        AddProductResponse productResponse = response.as(AddProductResponse.class);

        assertTrue(productResponse.isSuccess());
        assertEquals(String.format("(%s)", qtyItems), productResponse.getUpdatetopcartsectionhtml());
    }
}
