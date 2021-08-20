package com.demowebshop.tests.api;

import com.demowebshop.dao.UserRepository;
import com.demowebshop.dao.UserRepositoryImpl;
import com.demowebshop.model.User;
import com.demowebshop.service.Authorization;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApiLoginTests {


/*
## API Tests

// TODO: Send e-mail from product page with API
// TODO: Add product to wishlist with API
// TODO: Add product to cart with API

*/


    private UserRepository userRepository = new UserRepositoryImpl();
    private Authorization authorization = new Authorization();

    //TODO: test annotaions
    @Test
    void verifyStatusCodeIs302() {
        User user = userRepository.getUser();
        Response response = authorization.loginViaApi(user);

        Assertions.assertEquals("text/html; charset=utf-8", response.getContentType());
        Assertions.assertEquals(302, response.statusCode());
    }
}
