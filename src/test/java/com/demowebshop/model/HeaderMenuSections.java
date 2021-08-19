package com.demowebshop.model;

public enum HeaderMenuSections {
    LOGIN("login"), REGISTER("register"),
    LOG_OUT("logout"), SHOPPING_CART("cart"), WISHLIST("wishlist");

    public String getLinkName() {
        return linkName;
    }

    private String linkName;

    HeaderMenuSections(String name) {
        this.linkName = name;
    }
}
