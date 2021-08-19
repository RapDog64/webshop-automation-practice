package com.demowebshop.utility;

import com.demowebshop.model.User;
import com.github.javafaker.Faker;

public class UserGenerator {

    private UserGenerator() {
    }

    private static final Faker faker = new Faker();

    public static User generateValidUser() {
        String password = faker.internet().password();
        return  User.builder()
                .email(faker.internet().emailAddress())
                .firstname(faker.name().firstName())
                .lastname(faker.name().lastName())
                .password(password)
                .confirmPassword(password)
                .build();
    }
}
