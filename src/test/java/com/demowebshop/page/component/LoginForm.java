package com.demowebshop.page.component;

import com.codeborne.selenide.SelenideElement;
import com.demowebshop.page.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginForm extends BasePage {

    private SelenideElement loginBtn = $x("//input[@value='Log in']");
    private SelenideElement unsuccessfulLoginMessage = $(".validation-summary-errors");
    private SelenideElement loginTitleMessage = $(".returning-wrapper .title");

    @Step("Type the email: '{email}'")
    public LoginForm typeUserEmail(String email) {
        super.typeEmail(email);
        return this;
    }

    @Step("Type the password: '{password}'")
    public LoginForm typeUserPassword(String password) {
        super.typePassword(password);
        return this;
    }

    @Step("Click log in button")
    public void clickLogIn() {
        loginBtn.click();
    }

    @Step("Get unsuccessful login message '{message}'")
    public void getUnSuccessfulLoginMessage(String message) {
        unsuccessfulLoginMessage.shouldHave(text(message));
    }

    @Step("Get validation error message '{message}'")
    public SelenideElement getValidationErrorMessage(String message) {
        return $(".field-validation-error").shouldHave(text(message));
    }

    @Step("Get login form title: '{title}'")
    public void checkLoginFormTitle(String title) {
        loginTitleMessage.shouldHave(text(title));
    }
}
