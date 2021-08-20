package com.demowebshop.tests.ui;

import com.demowebshop.page.component.HeaderMenu;
import com.demowebshop.page.ProductList;
import com.demowebshop.tests.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

class WishlistTest extends BaseTest {

    @Test
    @Description("Add product to wishlist with UI")
    void AddProductToWishlist() {
        String productName = "health";
        open("/" + productName);

        ProductList productList = new ProductList();
        productList.addProductToWishlist();

        HeaderMenu headerMenu = new HeaderMenu();
        headerMenu.getProductQtyInWishlist().shouldHave(text("1"));
    }
}
