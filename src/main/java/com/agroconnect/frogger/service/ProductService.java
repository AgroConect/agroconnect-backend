package com.agroconnect.frogger.service;

import com.agroconnect.frogger.entity.Category;
import com.agroconnect.frogger.entity.Product;
import com.agroconnect.frogger.entity.Status;
import com.agroconnect.frogger.factory.ProductFactory;
import com.agroconnect.frogger.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductFactory productFactory;
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductFactory productFactory, ProductRepository productRepository) {
        this.productFactory = productFactory;
        this.productRepository = productRepository;
    }

    public Product addProduct(BigInteger farmerId, String name, String category, double price, int quantity, String status) {
        Product product = productFactory.createProduct(farmerId, name, category, price, quantity, status);
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Integer id) {
        return productRepository.findById(Long.valueOf(id));
    }

    public List<Product> getProductsByFarmer(Integer farmerId) {
        return productRepository.findByFarmerId(BigInteger.valueOf(farmerId));
    }

    public Product updateProduct(BigInteger id, String name, String category, double price, int quantity, String status) {
        Product product = productRepository.findById(Long.valueOf(String.valueOf(id)))
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(name);
        product.setCategory(Category.valueOf(category));
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setStatus(Status.valueOf(status));
        return productRepository.save(product);
    }

    public void deleteProduct(Integer id) {
        productRepository.deleteById(Long.valueOf(id));
    }
}