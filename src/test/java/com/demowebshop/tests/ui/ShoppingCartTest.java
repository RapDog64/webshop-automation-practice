package com.demowebshop.tests.ui;

import com.demowebshop.configuration.annotaions.allure.Layer;
import com.demowebshop.configuration.annotaions.extensions.LoginWithCookie;
import com.demowebshop.page.MainPage;
import com.demowebshop.page.ProductList;
import com.demowebshop.page.ShoppingCartPage;
import com.demowebshop.tests.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.demowebshop.model.HeaderMenuSections.SHOPPING_CART;

@Layer("web")
@Owner("Denis")
@Feature("Shopping cart")
@DisplayName("Shopping cart")
class ShoppingCartTest extends BaseTest {

    @Test
    @Story("Authorized user can add product to cart")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("authorized users can add a product to cart")
    @Description("validate authorized users can add a product to cart")
    @LoginWithCookie
    void validateAuthorizedUsersCanAddProductToCart() {
        String productName = "Build your own expensive computer";

        MainPage mainPage = open("", MainPage.class);
        mainPage.preAddProductToShoppingCart(productName);

        ProductList productList = new ProductList();
        productList.addProductToShoppingCart()
                .getHeaderMenu()
                .clickHeaderSection(SHOPPING_CART);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.verifyTheProductInTheShoppingCart(productName);
    }

    @Test
    @Story("Unauthorized user can add product to cart")
    @Severity(SeverityLevel.NORMAL)
    @Tags({@Tag("web"), @Tag("regress")})
    @Description("validate unauthorized users can add a product to cart")
    @DisplayName("unauthorized users can add a product to cart")
    void validateUnauthorizedUsersCanAddProductToCart() {
        String productName = "Build your own expensive computer";

        MainPage mainPage = open("", MainPage.class);
        mainPage.preAddProductToShoppingCart(productName);

        ProductList productList = new ProductList();
        productList.addProductToShoppingCart()
                .getHeaderMenu()
                .clickHeaderSection(SHOPPING_CART);

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.verifyTheProductInTheShoppingCart(productName);
    }
}
