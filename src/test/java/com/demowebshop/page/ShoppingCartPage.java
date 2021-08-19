package com.demowebshop.page;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingCartPage {

    @Step("Click checkout button")
    public void clickCheckoutButton() {
        $("#checkout").shouldBe(visible).click();
    }

    @Step("Accept policy")
    public void acceptPolicy() {
        $("#termsofservice").shouldBe(visible).click();
    }


    @Step("Verify '{productName}' in the shopping cart")
    public void verifyTheProductInTheShoppingCart(String productName) {
        $$(".cart-item-row").find(text(productName)).shouldBe(visible);
    }
}
