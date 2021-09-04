package com.demowebshop.tests.api;

import com.demowebshop.configuration.annotaions.allure.JiraIssue;
import com.demowebshop.configuration.annotaions.allure.Layer;
import com.demowebshop.dao.UserRepository;
import com.demowebshop.model.User;
import com.demowebshop.service.Authorization;
import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Layer("api")
@Owner("Igor")
@Feature("Authentication")
@DisplayName("Authentication suite")
class ApiLoginTests {

    private final UserRepository userRepository = new UserRepository();
    private final Authorization authorization = new Authorization();

    @Test
    @AllureId("4395")
    @JiraIssue("QC5-6")
    @Tags({@Tag("web"), @Tag("regress"), @Tag("prod")})
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("verify status code is 302")
    void verifyStatusCodeIs302() {
        User user = userRepository.getUser();
        Response response = authorization.loginViaApi(user.getEmail(), user.getPassword());

        Assertions.assertEquals("text/html; charset=utf-8", response.getContentType());
        Assertions.assertEquals(302, response.statusCode());
    }


}
