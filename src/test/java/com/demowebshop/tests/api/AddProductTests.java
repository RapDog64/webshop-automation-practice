package com.demowebshop.tests.api;

import com.demowebshop.configuration.annotaions.allure.JiraIssue;
import com.demowebshop.configuration.annotaions.allure.Layer;
import com.demowebshop.model.api.AddProductResponse;
import com.demowebshop.service.ProductService;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Lead;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Layer("api")
@Owner("Alex")
@Feature("Shopping cart")
@DisplayName("Shopping cart suite")
class AddProductTests {

    private final ProductService productService = new ProductService();

    @Test
    @AllureId("4394")
    @Tags({@Tag("web"), @Tag("regress"), @Tag("prod")})
    @Lead(value = "Denis")
    @JiraIssue("QC5-12")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Add product to cart")
    @Description("Add product to cart via api")
    void addProductToCart() {
        int qtyItems = 2;

        Response response = productService.addProductViaApi(qtyItems);
        AddProductResponse productResponse = response.as(AddProductResponse.class);

        assertTrue(productResponse.isSuccess());
        assertEquals(format("(%s)", qtyItems), productResponse.getUpdatetopcartsectionhtml());
    }
}
