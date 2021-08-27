package com.demowebshop.tests.ui;

import com.demowebshop.configuration.annotaions.allure.Layer;
import com.demowebshop.page.ProductList;
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

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

@Layer("web")
@Owner("Alex")
@Feature("Wishlist")
class WishlistTest extends BaseTest {

    @Test
    @Story("Add product to wishlist")
    @Severity(SeverityLevel.NORMAL)
    @Tags({@Tag("web"), @Tag("regress")})
    @Description("Add product to wishlist via UI")
    @DisplayName("Add product to wishlist")
    void AddProductToWishlist() {
        String productName = "health";

        ProductList productList = open("/" + productName, ProductList.class);
        productList.addProductToWishlist()
                .getHeaderMenu()
                .getProductQtyInWishlist().shouldHave(text("2"));
    }
}
