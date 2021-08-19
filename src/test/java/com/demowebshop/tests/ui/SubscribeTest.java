package com.demowebshop.tests.ui;

import com.demowebshop.model.User;
import com.demowebshop.page.MainPage;
import com.demowebshop.tests.BaseTest;
import com.demowebshop.utility.UserGenerator;
import io.qameta.allure.Description;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

class SubscribeTest extends BaseTest {

    @Test
    @Description("Subscribe to the newsletter")
    void subscribeToTheNewsletter() {
        User user = UserGenerator.generateValidUser();

        open("/", MainPage.class)
                .typeEmailIntoNewsLetterField(user.getEmail())
                .clickSubscribeButton()
                .getSubscribeMessage()
                .shouldHave(text("Thank you for signing up! A verification email has been sent. We appreciate your interest."));
    }
}
