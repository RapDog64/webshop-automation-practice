package com.demowebshop.tests;

import com.codeborne.selenide.Configuration;
import com.demowebshop.dao.UserRepository;
import com.demowebshop.dao.UserRepositoryImpl;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public abstract class BaseTest {

    protected UserRepository userRepository = new UserRepositoryImpl();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "http://demowebshop.tricentis.com";
        Configuration.browserSize = "1920x1080";
    }


    @AfterAll
    static void tearDown() {
        closeWebDriver();
    }

}
