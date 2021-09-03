package com.demowebshop.page.component;

import com.codeborne.selenide.ElementsCollection;
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

    private ElementsCollection listOfnNavigationMenuLinks = $$(".top-menu");

    @Step("verify navigation menu links are displayed")
    public void verifyNavigationMenuLinks() {
        listOfnNavigationMenuLinks.find(text(BOOK.getLinkName())).should(visible);
        listOfnNavigationMenuLinks.find(text(COMPUTERS.getLinkName())).should(visible);
        listOfnNavigationMenuLinks.find(text(ELECTRONICS.getLinkName())).should(visible);
        listOfnNavigationMenuLinks.find(text(APPAREL_AND_SHOES.getLinkName())).should(visible);
        listOfnNavigationMenuLinks.find(text(DIGITAL_DOWNLOADS.getLinkName())).should(visible);
        listOfnNavigationMenuLinks.find(text(JEWELRY.getLinkName())).should(visible);
        listOfnNavigationMenuLinks.find(text(GIFT_CARDS.getLinkName())).should(visible);
    }
}
