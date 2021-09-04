package com.demowebshop.tests.ui;

import com.codeborne.selenide.WebDriverRunner;
import com.demowebshop.configuration.annotaions.allure.JiraIssue;
import com.demowebshop.configuration.annotaions.allure.Layer;
import com.demowebshop.page.ShoppingCartPage;
import com.demowebshop.tests.BaseTest;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;

import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

@Layer("web")
@Owner("Alex")
@Feature("Checkout")
@DisplayName("Checkout suite")
class CheckoutTest extends BaseTest {

    @BeforeEach
    void addProduct() {
        Map<String, String> cookies = productService.addProductViaApi(1).cookies();
        open("/Themes/DefaultClean/Content/images/mobile-menu-collapse.png");
        cookies.forEach((key, value) -> WebDriverRunner.getWebDriver().manage().addCookie(new Cookie(key, value)));
    }

    @Test
    @AllureId("4396")
    @Story("Checkout as an unauthorized user")
    @Tags({@Tag("web"), @Tag("regress"), @Tag("prod")})
    @Severity(SeverityLevel.BLOCKER)
    @JiraIssue("QC5-6")
    @Description(value = "validate the system displays log in form if an unauthorized user want to checkout the order.")
    @DisplayName(value = "validate the system displays log in form")
    void validateTheSystemDisplaysLogInForm() {
        ShoppingCartPage shoppingCartPage = open("/cart", ShoppingCartPage.class);
        shoppingCartPage.acceptPolicy()
                .clickCheckoutButton()
                .getLoginForm()
                .checkLoginFormTitle()
                .shouldHave(text("Returning Customer"));
    }
}
