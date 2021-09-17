package com.demowebshop.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.demowebshop.page.component.HeaderMenu;
import com.demowebshop.page.component.HeaderNavigationMenu;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private SelenideElement newsletterMessage = $("#newsletter-result-block");
    private SelenideElement newsSubscribeBtn = $("#newsletter-subscribe-button");
    private SelenideElement newsLetterInput = $("#newsletter-email");
    private ElementsCollection addProductToCartFromMainPage = $$(".item-box");
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
        addProductToCartFromMainPage.find(text(name)).click();
        return this;
    }

    @Step("Type email into newsletter field")
    public MainPage typeEmailIntoNewsLetterField(String email) {
        newsLetterInput.val(email);
        return this;
    }

    @Step("Click the subscribe button")
    public MainPage clickSubscribeButton() {
        newsSubscribeBtn.click();
        return this;
    }

    @Step("Get subscribe result message '{message}'")
    public void getSubscribeMessage(String message) {
         newsletterMessage.shouldHave(text(message));
    }
}
