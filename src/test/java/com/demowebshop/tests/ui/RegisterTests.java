package com.demowebshop.tests.ui;

import com.demowebshop.configuration.annotaions.allure.Layer;
import com.demowebshop.model.Genders;
import com.demowebshop.model.User;
import com.demowebshop.page.component.HeaderMenu;
import com.demowebshop.page.component.RegisterForm;
import com.demowebshop.tests.BaseTest;
import com.demowebshop.utility.UserGenerator;
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

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

@Layer("web")
@Owner("Denis")
@Feature("Registration")
class RegisterTests extends BaseTest {

    @Test
    @Story("registration a new user")
    @Severity(SeverityLevel.CRITICAL)
    @Tags({@Tag("web"), @Tag("smoke")})
    @Description("Register a new user via UI")
    @DisplayName("register a new user")
    void registerNewUser() {
        User user = UserGenerator.generateValidUser();

        RegisterForm registerForm = open("/register", RegisterForm.class);
        registerForm.chooseGender(Genders.FEMALE)
                .typeNewUserEmail(user.getEmail())
                .typeFirstName(user.getFirstname())
                .typeLastName(user.getLastname())
                .typePassword(user.getPassword())
                .typeConfirmPassword(user.getConfirmPassword())
                .getSuccessfulRegistrationMessage().shouldHave(text("Your registration completed"));

        HeaderMenu headerMenu = new HeaderMenu();
        headerMenu.getProfileUserEmail().shouldHave(text(user.getEmail()));
    }
}
