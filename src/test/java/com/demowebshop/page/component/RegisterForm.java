package com.demowebshop.page.component;

import com.codeborne.selenide.SelenideElement;
import com.demowebshop.model.Genders;
import com.demowebshop.page.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RegisterForm extends BasePage {

    private SelenideElement firstNameInput = $("#FirstName");
    private SelenideElement lastNameInput = $("#LastName");
    private SelenideElement confirmPasswordInput = $("#ConfirmPassword");
    private SelenideElement registrationsMessage = $(".page-body .result");
    private SelenideElement registerBtn = $("#register-button");

    @Step("Type the firstname: '{firstName}'")
    public RegisterForm typeFirstName(String firstName) {
        firstNameInput.shouldBe(visible).val(firstName);
        return this;
    }

    @Step("Type the lastname: '{lastName}'")
    public RegisterForm typeLastName(String lastName) {
        lastNameInput.shouldBe(visible).val(lastName);
        return this;
    }

    @Step("Type the password: '{password}'")
    public RegisterForm typeUserPassword(String password) {
        super.typePassword(password);
        return this;
    }

    @Step("Type the confirm password: '{confirmPassword}'")
    public RegisterForm typeConfirmPassword(String confirmPassword) {
        confirmPasswordInput.shouldBe(visible).val(confirmPassword);
        return this;
    }

    @Step("click the register button")
    public RegisterForm clickRegister() {
        registerBtn.shouldBe(visible).click();
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
        return registrationsMessage.shouldBe(visible);
    }
}
