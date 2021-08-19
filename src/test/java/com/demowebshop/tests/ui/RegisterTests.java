package com.demowebshop.tests.ui;

import com.demowebshop.model.Genders;
import com.demowebshop.model.User;
import com.demowebshop.page.component.HeaderMenu;
import com.demowebshop.page.component.RegisterForm;
import com.demowebshop.tests.BaseTest;
import com.demowebshop.utility.UserGenerator;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

class RegisterTests extends BaseTest {

    @Test
    void registerNewUser() {
        User user = UserGenerator.generateValidUser();

        RegisterForm registerForm = open("/register", RegisterForm.class);
        registerForm.chooseGender(Genders.FEMALE)
                .typeNewUserEmail(user.getEmail())
                .typeFirstName(user.getFirstname())
                .typeLastName(user.getLastname())
                .typePassword(user.getPassword())
                .typeConfirmPassword(user.getConfirmPassword())
              //  .clickRegister()
                .getSuccessfulRegistrationMessage().shouldHave(text("Your registration completed"));

        HeaderMenu headerMenu = new HeaderMenu();
        headerMenu.getProfileUserEmail().shouldHave(text(user.getEmail()));
    }
}
