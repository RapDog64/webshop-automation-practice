package com.demowebshop.configuration.annotaions.extensions;

import com.demowebshop.configuration.report.AttachmentManager;
import com.demowebshop.dao.UserRepository;
import com.demowebshop.model.User;
import com.demowebshop.service.Authorization;
import io.restassured.response.Response;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.demowebshop.configuration.env.ApplicationConfigImpl.config;
import static java.util.Optional.ofNullable;

public class LoginExtension implements BeforeEachCallback {

    public static final Logger LOGGER = LoggerFactory.getLogger(AttachmentManager.class);
    private UserRepository userRepository = new UserRepository();
    private Authorization authorization = new Authorization();

    @Override
    public void beforeEach(ExtensionContext context) {
        User user = userRepository.getUser();

        if (ofNullable(user).isPresent()) {
            LOGGER.warn("The user was not found");
        }

        Response response = authorization.loginViaApi(user.getEmail(), user.getPassword());
        Map<String, String> cookies = response.getCookies();

        open(config.webUrl() + "/Themes/DefaultClean/Content/images/mobile-menu-collapse.png");
        cookies.forEach((key, value) -> getWebDriver().manage().addCookie(new Cookie("NOPCOMMERCE.AUTH", cookies.get("NOPCOMMERCE.AUTH"))));
    }
}
