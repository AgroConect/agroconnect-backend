package com.agroconnect.frogger.entity;

public enum Status {
    AVAILABLE, OUT_OF_STOCK, available, out_of_stock;

    public static Status fromString(String value) {
        return Status.valueOf(value.trim().toUpperCase());
    }
}