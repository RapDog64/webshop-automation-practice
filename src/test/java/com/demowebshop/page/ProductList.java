package com.demowebshop.page;

import com.demowebshop.page.component.HeaderMenu;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductList {

    private HeaderMenu headerMenu = new HeaderMenu();

    @Step("Get the header menu")
    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    @Step("Add product to shopping cart")
    public ProductList addProductToShoppingCart() {
        $x("//div[@class='add-to-cart-panel']/input[@type='button']").click();
        return this;
    }

    @Step("Add product to wishlist")
    public ProductList addProductToWishlist() {
        $(".add-to-wishlist-button").shouldBe(visible).click();
        return this;
    }
}
