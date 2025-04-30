package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.Category;
import com.agroconnect.frogger.entity.Product;
import com.agroconnect.frogger.entity.Status;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

@Component
public class DefaultProductFactory implements ProductFactory {

    @Override
    public Product createProduct(BigInteger farmerId, String name, String category, double price, int quantity, String status, String imageUrl) {
        Product product = new Product();
        product.setName(name);
        product.setCategory(Category.fromString(category));
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setImageUrl(imageUrl);
        product.setStatus(Status.fromString(status));
        return product;
    }
}
