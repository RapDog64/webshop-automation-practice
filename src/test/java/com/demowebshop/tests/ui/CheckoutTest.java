package com.demowebshop.tests.ui;

import com.demowebshop.configuration.annotaions.allure.JiraIssue;
import com.demowebshop.configuration.annotaions.allure.Layer;
import com.demowebshop.configuration.annotaions.extensions.AddProductViaApiExtension;
import com.demowebshop.page.ShoppingCartPage;
import com.demowebshop.tests.BaseTest;
import io.qameta.allure.AllureId;
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
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;

@Layer("web")
@Owner("Alex")
@Feature("Checkout")
@DisplayName("Checkout suite")
class CheckoutTest extends BaseTest {

    @Test
    @Tags({@Tag("web"), @Tag("regress"), @Tag("prod")})
    @Story("Checkout as an unauthorized user")
    @AllureId("4396")
    @Severity(SeverityLevel.BLOCKER)
    @JiraIssue("QC5-12")
    @DisplayName(value = "validate the system displays log in form")
    @Description(value = "validate the system displays log in form if an unauthorized user want to checkout the order.")
    @ExtendWith({AddProductViaApiExtension.class})
    void validateTheSystemDisplaysLogInForm() {
        ShoppingCartPage shoppingCartPage = open("/cart", ShoppingCartPage.class);
        shoppingCartPage.acceptPolicy()
                .clickCheckoutButton()
                .getLoginForm()
                .checkLoginFormTitle("Returning Customer");
    }
}
