package com.demowebshop.model;

public enum NavigationMenuLink {

    BOOK("Books"),
    COMPUTERS("Computers"),
    ELECTRONICS("Electronics"),
    APPAREL_AND_SHOES("Apparel & Shoes"),
    DIGITAL_DOWNLOADS("Digital downloads"),
    JEWELRY("Jewelry"),
    GIFT_CARDS("Gift Cards");

    private String linkName;

    NavigationMenuLink(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkName() {
        return linkName;
    }
}
