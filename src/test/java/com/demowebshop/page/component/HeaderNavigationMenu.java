package com.demowebshop.page.component;

import com.demowebshop.model.NavigationMenuLink;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class HeaderNavigationMenu {

    @Step("verify navigation menu links are displayed")
    public void verifyNavigationMenuLinks() {
        $$(".top-menu").find(text(NavigationMenuLink.BOOK.getLinkName())).should(visible);
        $$(".top-menu").find(text(NavigationMenuLink.COMPUTERS.getLinkName())).should(visible);
        $$(".top-menu").find(text(NavigationMenuLink.ELECTRONICS.getLinkName())).should(visible);
        $$(".top-menu").find(text(NavigationMenuLink.APPAREL_AND_SHOES.getLinkName())).should(visible);
        $$(".top-menu").find(text(NavigationMenuLink.DIGITAL_DOWNLOADS.getLinkName())).should(visible);
        $$(".top-menu").find(text(NavigationMenuLink.JEWELRY.getLinkName())).should(visible);
        $$(".top-menu").find(text(NavigationMenuLink.GIFT_CARDS.getLinkName())).should(visible);
    }
}
