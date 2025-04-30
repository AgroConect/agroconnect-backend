package com.agroconnect.frogger.entity;

public enum Category {
    VEGETABLE, FRUIT, GRAIN, DAIRY, MEAT;

    public static Category fromString(String value) {
        return Category.valueOf(value.trim().toUpperCase());
    }
}
