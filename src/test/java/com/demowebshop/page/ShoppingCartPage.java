package com.demowebshop.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.demowebshop.page.component.LoginForm;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ShoppingCartPage {

    private SelenideElement acceptPolicyBtn = $("#termsofservice");
    private SelenideElement checkoutBtn = $("#checkout");
    private ElementsCollection listOfProductInCart = $$(".cart-item-row");
    private LoginForm loginForm = new LoginForm();

    @Step("Get login form")
    public LoginForm getLoginForm() {
        return loginForm;
    }

    @Step("Click checkout button")
    public ShoppingCartPage clickCheckoutButton() {
        checkoutBtn.shouldBe(visible).click();
        return this;
    }

    @Step("Accept policy")
    public ShoppingCartPage acceptPolicy() {
        acceptPolicyBtn.shouldBe(visible).click();
        return this;
    }

    @Step("Verify '{productName}' in the shopping cart")
    public ShoppingCartPage verifyTheProductInTheShoppingCart(String productName) {
        listOfProductInCart.find(text(productName)).shouldBe(visible);
        return this;
    }
}
