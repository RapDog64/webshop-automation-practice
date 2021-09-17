package com.demowebshop.page;

import com.codeborne.selenide.SelenideElement;
import com.demowebshop.page.component.HeaderMenu;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductList {

    private SelenideElement addProductToCartBtn = $(".add-to-cart-button");
    private SelenideElement addToWishlistBtn = $(".add-to-wishlist-button");
    private SelenideElement notificationMessage = $("#bar-notification .content");
    private HeaderMenu headerMenu = new HeaderMenu();

    @Step("Get the header menu")
    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    @Step("Add product to shopping cart")
    public ProductList addProductToShoppingCart() {
        addProductToCartBtn.click();
        return this;
    }

    @Step("Add product to wishlist")
    public ProductList addProductToWishlist() {
        addToWishlistBtn.click();
        return this;
    }

    @Step("Get the notification message the product has been added to cart")
    public ProductList verifyProductIsAdded() {
        notificationMessage.shouldHave(text("The product has been added to your"));
        return this;
    }
}
