package com.demowebshop.tests.ui;

import com.demowebshop.page.MainPage;
import com.demowebshop.tests.BaseTest;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class NavigationMenuTests extends BaseTest {


    @Test
    void validateNavigationMenuLinkAreDisplayed() {

        MainPage mainPage = open("/", MainPage.class);
        mainPage.getHeaderNavigationMenu()
                .verifyNavigationMenuLinks();
    }
}
