package com.demowebshop.tests.ui;

import com.demowebshop.configuration.annotaions.allure.JiraIssue;
import com.demowebshop.configuration.annotaions.allure.Layer;
import com.demowebshop.page.MainPage;
import com.demowebshop.tests.BaseTest;
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

import static com.codeborne.selenide.Selenide.open;

@Layer("web")
@Owner("Denis")
@Feature("Navigation menu")
@DisplayName("Navigation menu suite")
class NavigationMenuTests extends BaseTest {

    @Test
    @AllureId("4397")
    @Story("Displaying navigation menu links")
    @Tags({@Tag("web"), @Tag("smoke"), @Tag("prod")})
    @Severity(SeverityLevel.CRITICAL)
    @JiraIssue("QC5-6")
    @Description("validate navigation menu link are displayed on the header menu")
    @DisplayName("validate navigation menu link are displayed")
    void validateNavigationMenuLinkAreDisplayed() {
        MainPage mainPage = open("/", MainPage.class);
        mainPage.getHeaderNavigationMenu()
                .verifyNavigationMenuLinks();
    }
}
