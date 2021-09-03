package com.demowebshop.page.component;

import com.codeborne.selenide.SelenideElement;
import com.demowebshop.page.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginForm extends BasePage {

    private SelenideElement loginBtn = $x("//input[@value='Log in']");
    private SelenideElement unsuccessfulLoginMessage = $(".validation-summary-errors");
    private SelenideElement loginTitleMessage = $(".returning-wrapper .title");

    @Step("Type the email: {email}")
    public LoginForm typeUserEmail(String email) {
       super.typeEmail(email);
       return this;
    }

    @Step("Type the password: {password}")
    public LoginForm typeUserPassword(String password){
        super.typePassword(password);
        return this;
    }

    @Step("Click log in button")
    public void clickLogIn() {
        loginBtn.shouldBe(visible).click();
    }

    @Step("Get unsuccessful login message")
    public SelenideElement getUnSuccessfulLoginMessage() {
        return unsuccessfulLoginMessage.shouldBe(visible);
    }

    @Step("Get validation error message")
    public SelenideElement getValidationErrorMessage() {
        return $(".field-validation-error").shouldBe(visible);
    }

    @Step("Get login form title")
    public SelenideElement checkLoginFormTitle() {
        return loginTitleMessage.shouldBe(visible);
    }
}
