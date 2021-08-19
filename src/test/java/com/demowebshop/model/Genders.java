package com.demowebshop.model;

public enum Genders {
    MALE("male"), FEMALE("female");

    private String gender;

    Genders(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
