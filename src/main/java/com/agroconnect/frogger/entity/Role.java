package com.agroconnect.frogger.entity;

public enum Role {
    ADMIN,
    FARMER,
    CUSTOMER,
    DELIVERYMAN;

    public static Role fromString(String value) {
        return Role.valueOf(value.toUpperCase());
    }
}