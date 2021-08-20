package com.demowebshop.tests.ui;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.demowebshop.page.ShoppingCartPage;
import com.demowebshop.page.component.LoginForm;
import com.demowebshop.tests.BaseTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

class CheckoutTest extends BaseTest {

    @BeforeEach
    void addProduct() {
        Map<String, String> cookies = productService.addProductViaApi(1).cookies();

        open("/Themes/DefaultClean/Content/images/mobile-menu-collapse.png");

        cookies.entrySet().stream().forEach(cookie -> {
            WebDriverRunner.getWebDriver().manage().addCookie(new Cookie(cookie.getKey(), cookie.getValue()));
        });
    }

    @Test
    @Description(value = "Validate the system displays log in form if an unauthorized user want to checkout the order.")
    void validateTheSystemDisplaysLogInForm() {
        open("/cart");

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.acceptPolicy();
        shoppingCartPage.clickCheckoutButton();

        LoginForm loginForm = new LoginForm();
        loginForm.checkLoginFormTitle().shouldHave(Condition.text("Returning Customer"));
    }
}
