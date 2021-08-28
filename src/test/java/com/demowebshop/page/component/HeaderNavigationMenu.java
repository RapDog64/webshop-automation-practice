package com.demowebshop.page.component;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.demowebshop.model.NavigationMenuLink.APPAREL_AND_SHOES;
import static com.demowebshop.model.NavigationMenuLink.BOOK;
import static com.demowebshop.model.NavigationMenuLink.COMPUTERS;
import static com.demowebshop.model.NavigationMenuLink.DIGITAL_DOWNLOADS;
import static com.demowebshop.model.NavigationMenuLink.ELECTRONICS;
import static com.demowebshop.model.NavigationMenuLink.GIFT_CARDS;
import static com.demowebshop.model.NavigationMenuLink.JEWELRY;

public class HeaderNavigationMenu {

    @Step("verify navigation menu links are displayed")
    public void verifyNavigationMenuLinks() {
        $$(".top-menu").find(text(BOOK.getLinkName())).should(visible);
        $$(".top-menu").find(text(COMPUTERS.getLinkName())).should(visible);
        $$(".top-menu").find(text(ELECTRONICS.getLinkName())).should(visible);
        $$(".top-menu").find(text(APPAREL_AND_SHOES.getLinkName())).should(visible);
        $$(".top-menu").find(text(DIGITAL_DOWNLOADS.getLinkName())).should(visible);
        $$(".top-menu").find(text(JEWELRY.getLinkName())).should(visible);
        $$(".top-menu").find(text(GIFT_CARDS.getLinkName())).should(visible);
    }
}
