package com.demowebshop.tests.ui;

import com.demowebshop.configuration.annotaions.allure.Layer;
import com.demowebshop.model.HeaderMenuSections;
import com.demowebshop.model.User;
import com.demowebshop.page.MainPage;
import com.demowebshop.page.component.HeaderMenu;
import com.demowebshop.page.component.LoginForm;
import com.demowebshop.tests.BaseTest;
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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.parameter;

@Layer("web")
@Owner("Denis")
@Feature("Authentication")
@DisplayName("Authentication")
class LoginTests extends BaseTest {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Story("Successful log in")
    @Tags({@Tag("web"), @Tag("regress"), @Tag("prod")})
    @DisplayName("Log in as a user")
    @Description("Log in as a user with valid credentials")
    void loginWithValidCredentials() {
        User user = userRepository.getUser();

        MainPage mainPage = open("/", MainPage.class);
        mainPage.getHeaderMenu()
                .clickHeaderSection(HeaderMenuSections.LOGIN)
                .getLoginForm()
                .typeUserEmail(user.getEmail())
                .typeUserPassword(user.getPassword())
                .clickLogIn();

        HeaderMenu headerMenu = new HeaderMenu();
        headerMenu.getProfileUserEmail().shouldHave(text(user.getEmail()));
    }

    @Story("Log in with incorrect credentials")
    @DisplayName("User should see unsuccessful login message")
    @Description("User should see unsuccessful login message if the credentials are invalid")
    @Severity(SeverityLevel.NORMAL)
    @ParameterizedTest
    @CsvSource({"test@emial.com,TEST", "Java@emial.com, JAVA"})
    void loginWithIncorrectCredentials(String email, String password) {
        parameter("user email", email);
        parameter("user password", password);

        LoginForm loginForm = open("/login", LoginForm.class);
        loginForm.typeUserEmail(email);
        loginForm.typeUserPassword(password);
        loginForm.clickLogIn();
        loginForm.getUnSuccessfulLoginMessage()
                .shouldHave(text("Login was unsuccessful. Please correct the errors and try again."));
    }

    @Story("Log in with invalid credentials")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("User should see invalid Email format")
    @Description("User should see invalid Email format message if the email is not in the email format")
    @ParameterizedTest
    @CsvSource({"test432423,TEST", "s##$@#$@#4@emial.com, TEST"})
    void loginWithInvalidEmailFormat(String email, String password) {
        parameter("user email", email);
        parameter("user password", password);

        LoginForm loginForm = open("/login", LoginForm.class);
        loginForm.typeUserEmail(email);
        loginForm.typeUserPassword(password);
        loginForm.clickLogIn();
        loginForm.getValidationErrorMessage()
                .shouldHave(text("Please enter email address."));
    }
}
