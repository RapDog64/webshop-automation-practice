package com.demowebshop.tests.api;

import com.demowebshop.dao.UserRepository;
import com.demowebshop.dao.UserRepositoryImpl;
import com.demowebshop.model.User;
import com.demowebshop.service.Authorization;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

class ApiLoginTests {

    private UserRepository userRepository = new UserRepositoryImpl();
    private Authorization authorization = new Authorization();

    //TODO: test annotaions
    @Test
    void verifyStatusCodeIs200() {
        User user = userRepository.getUser();

        Response response = authorization.loginViaApi(user);

        //TODO: test assertions
        response.getBody();
    }
}
