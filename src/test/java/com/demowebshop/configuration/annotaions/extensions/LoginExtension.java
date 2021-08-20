package com.demowebshop.configuration.annotaions.extensions;

import com.demowebshop.dao.UserRepository;
import com.demowebshop.dao.UserRepositoryImpl;
import com.demowebshop.model.User;
import com.demowebshop.service.Authorization;
import io.restassured.response.Response;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginExtension implements BeforeEachCallback {

    private UserRepository userRepository = new UserRepositoryImpl();
    private Authorization authorization = new Authorization();

    @Override
    public void beforeEach(ExtensionContext context) {
        User user = userRepository.getUser();
        Response response = authorization.loginViaApi(user);
        Map<String, String> cookies = response.getCookies();

        open("http://demowebshop.tricentis.com/Themes/DefaultClean/Content/images/mobile-menu-collapse.png");

        cookies.entrySet().stream().forEach(cookie -> {
            getWebDriver().manage().addCookie(new Cookie("NOPCOMMERCE.AUTH", cookies.get("NOPCOMMERCE.AUTH")));
        });
    }
}
