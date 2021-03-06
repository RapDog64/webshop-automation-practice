package com.demowebshop.page.component;

import com.codeborne.selenide.SelenideElement;
import com.demowebshop.model.HeaderMenuSections;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.valueOf;

public class HeaderMenu {

    private SelenideElement qtyOfProductsText = $(".wishlist-qty");
    private SelenideElement userProfileEmailField = $(".account");
    private LoginForm loginForm = new LoginForm();
    private RegisterForm registerForm = new RegisterForm();

    @Step("Get log in form")
    public LoginForm getLoginForm() {
        return loginForm;
    }

    @Step("Get registration form")
    public RegisterForm getRegisterForm() {
        return registerForm;
    }

    @Step("Click on the button {MenuName}")
    public HeaderMenu clickHeaderSection(HeaderMenuSections MenuName) {
        $("div .header-links > ul >li a[href='/" + MenuName.getLinkName() + "']").click();
        return this;
    }

    @Step(value = "Get user profile email")
    public void getProfileUserEmail(String userEmail) {
        userProfileEmailField.shouldHave(text(userEmail));
    }

    @Step(value = "Get quantity of the added products in the wishlist")
    public void getProductQtyInWishlist(int qty) {
        qtyOfProductsText.shouldHave(text(valueOf(qty)));
    }
}
