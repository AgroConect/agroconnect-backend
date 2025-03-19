package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.Category;
import com.agroconnect.frogger.entity.Product;
import com.agroconnect.frogger.entity.Status;
import org.springframework.stereotype.Component;

@Component
public class DefaultProductFactory implements ProductFactory {

    @Override
    public Product createProduct(String name, String category, double price, int quantity, String status) {
        Product product = new Product();
        product.setName(name);
        product.setCategory(Category.valueOf(category));
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setStatus(Status.valueOf(status));

        return product;
    }
}
