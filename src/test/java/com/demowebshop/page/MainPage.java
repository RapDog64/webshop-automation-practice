package com.demowebshop.page;

import com.codeborne.selenide.SelenideElement;
import com.demowebshop.page.component.HeaderMenu;
import com.demowebshop.page.component.HeaderNavigationMenu;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private SelenideElement newsletterMessage = $("#newsletter-result-block");
    private SelenideElement newsSubscribeBtn = $("#newsletter-subscribe-button");
    private SelenideElement newsLetterInput = $("#newsletter-email");
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
        // TODO: change Xpath
        SelenideElement addProductToCartFromMainPage = $x("//h2//a[contains(text(),'" + name + "')]/parent::h2/following-sibling::div[@class='add-info']/div[@class='buttons']");
        addProductToCartFromMainPage.click();
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
    public SelenideElement getSubscribeMessage(String message) {
        return newsletterMessage.shouldHave(text(message));
    }
}
