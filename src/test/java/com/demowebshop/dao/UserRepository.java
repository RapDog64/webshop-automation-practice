package com.demowebshop.dao;

import com.demowebshop.configuration.database.CustomDatabase;
import com.demowebshop.model.User;

public class UserRepository {

    public User getUser() {
       return CustomDatabase.getInstance()
               .getUsers()
               .stream()
               .findFirst()
               .orElseThrow(IllegalArgumentException::new);
    }
}
