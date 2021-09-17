package com.demowebshop.tests.ui;

import com.demowebshop.configuration.annotaions.allure.JiraIssue;
import com.demowebshop.configuration.annotaions.allure.Layer;
import com.demowebshop.model.Genders;
import com.demowebshop.model.User;
import com.demowebshop.page.component.HeaderMenu;
import com.demowebshop.page.component.RegisterForm;
import com.demowebshop.tests.BaseTest;
import com.demowebshop.utility.UserGenerator;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

@Layer("web")
@Owner("Denis")
@Feature("Registration")
@DisplayName("Registration suite")
class RegisterTests extends BaseTest {

    @Test
    @AllureId("4401")
    @Story("Registration a new user")
    @Severity(SeverityLevel.CRITICAL)
    @Lead(value = "Denis")
    @JiraIssue("QC5-12")
    @Tags({@Tag("web"), @Tag("smoke")})
    @Description("Register a new user via UI")
    @DisplayName("Register a new user")
    void registerNewUser() {
        User user = UserGenerator.generateValidUser();

        RegisterForm registerForm = open("/register", RegisterForm.class);
        registerForm.chooseGender(Genders.FEMALE)
                .typeNewUserEmail(user.getEmail())
                .typeFirstName(user.getFirstname())
                .typeLastName(user.getLastname())
                .typeUserPassword(user.getPassword())
                .typeConfirmPassword(user.getConfirmPassword())
                .getSuccessfulRegistrationMessage("Your registration completed");

        HeaderMenu headerMenu = new HeaderMenu();
        headerMenu.getProfileUserEmail(user.getEmail());
    }
}
