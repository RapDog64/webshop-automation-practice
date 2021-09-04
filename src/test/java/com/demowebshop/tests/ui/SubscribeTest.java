package com.demowebshop.tests.ui;

import com.demowebshop.configuration.annotaions.allure.JiraIssue;
import com.demowebshop.configuration.annotaions.allure.Layer;
import com.demowebshop.model.User;
import com.demowebshop.page.MainPage;
import com.demowebshop.tests.BaseTest;
import com.demowebshop.utility.UserGenerator;
import io.qameta.allure.AllureId;
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
@Owner("Alex")
@Feature("Subscribe")
@DisplayName("Subscribe suite")
class SubscribeTest extends BaseTest {

    @Test
    @AllureId("4403")
    @JiraIssue("QC5-12")
    @Story("Subscribe to the newsletter")
    @Tags({@Tag("web"), @Tag("regress")})
    @Severity(SeverityLevel.NORMAL)
    @Description("Subscribe to the newsletter via UI")
    @DisplayName("Subscribe to the newsletter")
    void subscribeToTheNewsletter() {
        final String expectedMessage = "Thank you for signing up! A verification email has been sent. We appreciate your interest.";
        User user = UserGenerator.generateValidUser();

        MainPage mainPage = open("/", MainPage.class);
        mainPage.typeEmailIntoNewsLetterField(user.getEmail())
                .clickSubscribeButton()
                .getSubscribeMessage()
                .shouldHave(text(expectedMessage));
    }
}
