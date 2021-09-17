package com.demowebshop.configuration.database;

import com.demowebshop.model.Genders;
import com.demowebshop.model.User;

import static com.demowebshop.configuration.env.ApplicationConfigImpl.config;

import java.util.ArrayList;
import java.util.List;

public class CustomDatabase {

    private static CustomDatabase instance = null;
    private static List<User> users = new ArrayList<>();

    private CustomDatabase() {
    }

    public static synchronized CustomDatabase getInstance() {
        if (instance == null) {
            instance = new CustomDatabase();
            addDefaultUser();
        }
        return instance;
    }

    public List<User> getUsers() {
        return users;
    }

    private static void addDefaultUser() {
        User defaultUser = User.builder()
                .firstname("Ivan")
                .lastname("Petrov")
                .gender(Genders.MALE.getGender())
                .email(config.userEmail())
                .password(config.userPassword())
                .confirmPassword(config.userPassword())
                .build();

        users.add(defaultUser);
    }
}
