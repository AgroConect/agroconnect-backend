package com.agroconnect.frogger.service;

import com.agroconnect.frogger.entity.Product;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface ProductService {

    Product addProduct(Product product, BigInteger farmerId);

//    Product addProduct(Product product, BigInteger farmerId);

    List<Product> getAllProducts();

    Optional<Object> getProductById(BigInteger id);

//    Product updateProduct(BigInteger id, String name, String category, Double price, Integer quantity, String status);

    void deleteProduct(BigInteger id);

    void updateProduct(BigInteger id, Product updatedProduct);

    Product patchProduct(BigInteger id, Map<String,Object> updates);
}