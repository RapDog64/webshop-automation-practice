package com.demowebshop.tests.ui;

import com.demowebshop.configuration.annotaions.extensions.LoginWithCookie;
import com.demowebshop.page.MainPage;
import com.demowebshop.page.ProductList;
import com.demowebshop.page.ShoppingCartPage;
import com.demowebshop.page.component.HeaderMenu;
import com.demowebshop.tests.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;
import static com.demowebshop.model.HeaderMenuSections.SHOPPING_CART;

class ShoppingCartTest extends BaseTest {

    // TODO: Validate authorized users can add a product to cart
    // TODO: Validate unauthorized users can add a product to cart

    @AfterEach
    void clearCookie(){
        clearBrowserCookies();
    }

    @Test
    @DisplayName("authorized users can add a product to cart")
    @Description("Validate authorized users can add a product to cart")
    @LoginWithCookie
    void validateAuthorizedUsersCanAddProductToCart() {
        String productName = "Build your own expensive computer";

        open("");
        MainPage mainPage = new MainPage();
        mainPage.preAddProductToShoppingCart(productName);

        ProductList productList = new ProductList();
        productList.addProductToShoppingCart();

        HeaderMenu headerMenu = new HeaderMenu();
        headerMenu.clickHeaderSection(SHOPPING_CART);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.verifyTheProductInTheShoppingCart(productName);
    }

    @Test
    @DisplayName("Unauthorized users can add a product to cart")
    @Description("Validate unauthorized users can add a product to cart")
    void validateUnauthorizedUsersCanAddProductToCart() {
        String productName = "Build your own expensive computer";

        open("");
        MainPage mainPage = new MainPage();
        mainPage.preAddProductToShoppingCart(productName);

        ProductList productList = new ProductList();
        productList.addProductToShoppingCart();

        HeaderMenu headerMenu = new HeaderMenu();
        headerMenu.clickHeaderSection(SHOPPING_CART);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.verifyTheProductInTheShoppingCart(productName);
    }
}
