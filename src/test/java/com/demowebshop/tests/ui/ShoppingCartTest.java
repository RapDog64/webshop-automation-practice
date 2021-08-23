package com.demowebshop.tests.ui;

import com.demowebshop.configuration.annotaions.allure.Layer;
import com.demowebshop.configuration.annotaions.extensions.LoginWithCookie;
import com.demowebshop.page.MainPage;
import com.demowebshop.page.ProductList;
import com.demowebshop.page.ShoppingCartPage;
import com.demowebshop.page.component.HeaderMenu;
import com.demowebshop.tests.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.open;
import static com.demowebshop.model.HeaderMenuSections.SHOPPING_CART;

@Layer("web")
@Owner("Denis")
@Feature("Shopping cart")
class ShoppingCartTest extends BaseTest {

    @AfterEach
    void clearCookie(){
        clearBrowserCookies();
    }

    @Test
    @Story("Authorized user can add product to cart")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("web"), @Tag("regress")})
    @DisplayName("authorized users can add a product to cart")
    @Description("validate authorized users can add a product to cart")
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
    @Story("Unauthorized user can add product to cart")
    @Severity(SeverityLevel.NORMAL)
    @Tags({@Tag("web"), @Tag("regress")})
    @Description("Validate unauthorized users can add a product to cart")
    @DisplayName("Unauthorized users can add a product to cart")
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
