package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.Product;

import java.math.BigInteger;

public interface ProductFactory {
    Product createProduct(BigInteger farmerId, String name, String category, double price, int quantity, String status);
}

