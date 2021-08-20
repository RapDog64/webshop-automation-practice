package com.demowebshop.page;

import com.codeborne.selenide.SelenideElement;
import com.demowebshop.page.component.HeaderMenu;
import com.demowebshop.page.component.HeaderNavigationMenu;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private HeaderMenu headerMenu = new HeaderMenu();
    private HeaderNavigationMenu headerNavigationMenu = new HeaderNavigationMenu();

    @Step("Get the header menu")
    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    @Step("Get the header navigation menu")
    public HeaderNavigationMenu getHeaderNavigationMenu() {
        return headerNavigationMenu;
    }

    @Step("Pre add product to shopping cart")
    public MainPage preAddProductToShoppingCart(String name) {
        $x("//h2//a[contains(text(),'" + name + "')]/parent::h2/following-sibling::div[@class='add-info']/div[@class='buttons']")
                .shouldBe(visible).click();
        return this;
    }

    @Step("Type email into newsletter field")
    public MainPage typeEmailIntoNewsLetterField(String email) {
        $("#newsletter-email").val(email);
        return this;
    }

    @Step("")
    public MainPage clickSubscribeButton() {
        $("#newsletter-subscribe-button").shouldBe(visible).click();
        return this;
    }

    @Step("Get subscribe result message")
    public SelenideElement getSubscribeMessage() {
        return $("#newsletter-result-block").shouldBe(visible);
    }
}
