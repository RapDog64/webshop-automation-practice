package com.demowebshop.page;

import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    protected void typeEmail(String email) {
        $("#Email").val(email);
    }

    protected void typePassword(String password) {
        $("#Password").val(password);
    }
}
