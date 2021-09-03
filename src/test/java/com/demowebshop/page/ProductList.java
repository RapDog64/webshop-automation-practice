package com.demowebshop.page;

import com.codeborne.selenide.SelenideElement;
import com.demowebshop.page.component.HeaderMenu;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductList {

    private SelenideElement addProductToCartBtn = $x("//div[@class='add-to-cart-panel']/input[@type='button']");
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
        addToWishlistBtn.shouldBe(visible).click();
        return this;
    }

    @Step("Get the notification message the product has been added to cart")
    public ProductList verifyProductIsAdded() {
        notificationMessage.shouldHave(text("The product has been added to your"));
        return this;
    }
}
