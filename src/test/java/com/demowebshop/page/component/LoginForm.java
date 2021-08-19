package com.demowebshop.page.component;

import com.codeborne.selenide.SelenideElement;
import com.demowebshop.page.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginForm extends BasePage {

    @Step("Type the email: {email}")
    public LoginForm typeUserEmail(String email) {
       super.typeEmail(email);
       return this;
    }

    @Step("Type the password: {password}")
    public LoginForm typeUserPassword(String password){
        $("#Password").shouldBe(visible).val(password);
        return this;
    }

    @Step("Click log in button")
    public void clickLogIn() {
        $x("//input[@value='Log in']").shouldBe(visible).click();
    }

    @Step("Get unsuccessful login message")
    public SelenideElement getUnSuccessfulLoginMessage() {
        return $(".validation-summary-errors").shouldBe(visible);
    }

    @Step("Get validation error message")
    public SelenideElement getValidationErrorMessage() {
        return $(".field-validation-error").shouldBe(visible);
    }

    @Step("Get login form title")
    public SelenideElement checkLoginFormTitle() {
        return $(".returning-wrapper .title").shouldBe(visible);
    }
}
