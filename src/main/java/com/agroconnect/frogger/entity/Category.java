package com.agroconnect.frogger.entity;

public enum Category {
    VEGETABLE, FRUIT, GRAIN, DAIRY, MEAT, vegetable, fruit, grain, diary, meat;

//    public String toUpperCase() {
//    }
    public static Category fromString(String value) {
        return Category.valueOf(value.trim().toUpperCase());
    }
}
