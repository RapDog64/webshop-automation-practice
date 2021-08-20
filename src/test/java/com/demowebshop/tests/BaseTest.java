package com.demowebshop.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demowebshop.dao.UserRepository;
import com.demowebshop.dao.UserRepositoryImpl;
import com.demowebshop.service.ProductService;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@ExtendWith({AllureJunit5.class})
public abstract class BaseTest {

    protected ProductService productService = new ProductService();
    protected UserRepository userRepository = new UserRepositoryImpl();

    @BeforeAll
    static void setUpBrowser() {
        Configuration.baseUrl = "http://demowebshop.tricentis.com";
        Configuration.browserSize = "1920x1080";
//        Configuration.headless = true;
    }

    @BeforeEach
    void addAllureListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void closeBrowser() {
        closeWebDriver();
    }
}
