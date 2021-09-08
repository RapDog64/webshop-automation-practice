package com.demowebshop.page.component;

import com.codeborne.selenide.SelenideElement;
import com.demowebshop.model.Genders;
import com.demowebshop.page.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegisterForm extends BasePage {

    private SelenideElement firstNameInput = $("#FirstName");
    private SelenideElement lastNameInput = $("#LastName");
    private SelenideElement confirmPasswordInput = $("#ConfirmPassword");
    private SelenideElement registrationsMessage = $(".page-body .result");
    private SelenideElement registerBtn = $("#register-button");
    private SelenideElement genderMale = $("#gender-male");
    private SelenideElement genderFemale = $("#gender-female");

    @Step("Type the firstname: '{firstName}'")
    public RegisterForm typeFirstName(String firstName) {
        firstNameInput.val(firstName);
        return this;
    }

    @Step("Type the lastname: '{lastName}'")
    public RegisterForm typeLastName(String lastName) {
        lastNameInput.val(lastName);
        return this;
    }

    @Step("Type the password: '{password}'")
    public RegisterForm typeUserPassword(String password) {
        super.typePassword(password);
        return this;
    }

    @Step("Type the confirm password: '{confirmPassword}'")
    public RegisterForm typeConfirmPassword(String confirmPassword) {
        confirmPasswordInput.val(confirmPassword);
        return this;
    }

    @Step("click the register button")
    public RegisterForm clickRegister() {
        registerBtn.click();
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
            genderMale.click();
        } else if (gender.getGender().equalsIgnoreCase("female")) {
            genderFemale.click();
        }
        return this;
    }

    @Step("Get the successful registration message: '{message}'")
    public SelenideElement getSuccessfulRegistrationMessage(String message) {
        return registrationsMessage.shouldHave(text(message));
    }
}
