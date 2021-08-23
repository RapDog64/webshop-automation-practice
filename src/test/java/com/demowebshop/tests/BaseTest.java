package com.demowebshop.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demowebshop.configuration.annotaions.extensions.ReportDetailsExtension;
import com.demowebshop.configuration.env.ApplicationConfigImpl;
import com.demowebshop.configuration.report.AttachmentManager;
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
import static com.demowebshop.configuration.env.ApplicationConfigImpl.config;

@ExtendWith({AllureJunit5.class, ReportDetailsExtension.class})
public abstract class BaseTest {

    protected ProductService productService = new ProductService();
    protected UserRepository userRepository = new UserRepositoryImpl();


    @BeforeAll
    static void setUpBrowser() {
        Configuration.baseUrl = config.webUrl();
        Configuration.browserSize = "1920x1080";
        Configuration.headless = true;
    }

    @BeforeEach
    void addAllureListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
    @AfterEach
    void reportDetails() {
        String sessionId = AttachmentManager.getSessionId();

        /*
        AttachmentManager.screenshotAs("The screenshot of the test");
        AttachmentManager.pageSource();*/
        AttachmentManager.browserConsoleLogs();
        closeWebDriver();

        if (ApplicationConfigImpl.isVideoTurnedOn()) {
            AttachmentManager.addVideo(sessionId);
        }
    }
}
