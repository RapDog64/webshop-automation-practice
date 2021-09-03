package com.demowebshop.page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    protected void typeEmail(String email) {
        $("#Email").shouldBe(visible).val(email);
    }

    protected void typePassword(String password) {
        $("#Password").shouldBe(visible).val(password);
    }
}
