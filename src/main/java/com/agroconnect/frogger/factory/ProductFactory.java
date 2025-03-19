package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.Product;

public interface ProductFactory {
    Product createProduct(String name, String category, double price, int quantity, String status);
}

