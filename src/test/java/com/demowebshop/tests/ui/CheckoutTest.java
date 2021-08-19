package com.demowebshop.tests.ui;

import com.codeborne.selenide.Condition;
import com.demowebshop.page.component.LoginForm;
import com.demowebshop.page.ShoppingCartPage;
import com.demowebshop.tests.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

class CheckoutTest extends BaseTest {

    @Test
    @Description(value = "Validate the system displays log in form if an unauthorized user want to checkout the order.")
    void validateTheSystemDisplaysLogInForm() {
        // TODO: add product to the cart via API

        open("/cart");

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.acceptPolicy();
        shoppingCartPage.clickCheckoutButton();

        LoginForm loginForm = new LoginForm();
        loginForm.checkLoginFormTitle().shouldHave(Condition.text("Returning Customer"));

    }
}
