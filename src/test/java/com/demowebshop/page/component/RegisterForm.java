package com.demowebshop.page.component;

import com.codeborne.selenide.SelenideElement;
import com.demowebshop.model.Genders;
import com.demowebshop.page.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RegisterForm extends BasePage {

    @Step("Type the firstname: '{firstName}'")
    public RegisterForm typeFirstName(String firstName) {
        $("#FirstName").shouldBe(visible).val(firstName);
        return this;
    }

    @Step("Type the lastname: '{lastName}'")
    public RegisterForm typeLastName(String lastName) {
        $("#LastName").shouldBe(visible).val(lastName);
        return this;
    }

    @Step("Type the password: '{password}'")
    public RegisterForm typePassword(String password) {
        $("#Password").shouldBe(visible).val(password);
        return this;
    }

    @Step("Type the confirm password: '{confirmPassword}'")
    public RegisterForm typeConfirmPassword(String confirmPassword) {
        $("#ConfirmPassword").shouldBe(visible).val(confirmPassword);
        return this;
    }

    @Step("click the register button")
    public RegisterForm clickRegister() {
        $("#register-button").shouldBe(visible).click();
        return this;
    }

    @Step("Type the email: {email}")
    public RegisterForm typeNewUserEmail(String email) {
        super.typeEmail(email);
        return this;
    }

    @Step("Choose gender: '{gender}'")
    public RegisterForm chooseGender(Genders gender) {
        if (gender.getGender().equalsIgnoreCase("male")) {
            $("#gender-male").click();
        } else if (gender.getGender().equalsIgnoreCase("female")) {
            $("#gender-female").click();
        }
        return this;
    }

    @Step("Get the successful registration message")
    public SelenideElement getSuccessfulRegistrationMessage() {
        return $(".page-body .result").shouldBe(visible);
    }
}
