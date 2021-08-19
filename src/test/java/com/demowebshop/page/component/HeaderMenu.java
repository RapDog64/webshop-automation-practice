package com.demowebshop.page.component;

import com.codeborne.selenide.SelenideElement;
import com.demowebshop.model.HeaderMenuSections;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HeaderMenu {

    @Step("Get log in form")
    public LoginForm getLoginForm() {
        return  new LoginForm();
    }

    @Step("Get registration form")
    public RegisterForm getRegisterForm() {
        return new RegisterForm();
    }

    @Step("Click on the button {MenuName}")
    public HeaderMenu clickHeaderSection(HeaderMenuSections MenuName) {
        $("div .header-links > ul >li a[href='/" + MenuName.getLinkName() + "']").click();
        return this;
    }

    @Step(value = "Get user profile email")
    public SelenideElement getProfileUserEmail() {
        return $(".account").shouldBe(visible);
    }

    @Step(value = "Get quantity of the added products in the wishlist")
    public SelenideElement getProductQtyInWishlist() {
        return $(".wishlist-qty").shouldBe(visible);
    }
}
