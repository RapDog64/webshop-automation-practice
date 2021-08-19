package com.demowebshop.page;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductList {

    @Step("Add product to shopping cart")
    public void addProductToShoppingCart() {
        $x("//div[@class='add-to-cart-panel']/input[@type='button']").click();
    }

    @Step("Add product to wishlist")
    public void addProductToWishlist() {
        $(".add-to-wishlist-button").shouldBe(visible).click();
    }
}
