package com.agroconnect.frogger.service.impl;

import com.agroconnect.frogger.entity.Category;
import com.agroconnect.frogger.entity.Product;
import com.agroconnect.frogger.entity.Status;
import com.agroconnect.frogger.factory.ProductFactory;
import com.agroconnect.frogger.repository.ProductRepository;
import com.agroconnect.frogger.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl extends ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImpl(ProductFactory productFactory, ProductRepository productRepository) {
        super(productFactory, productRepository);
    }

    @Override
    public Product addProduct(BigInteger farmerId, String name, String category, Double price, Integer quantity, String status) {
        Product product = new Product(farmerId, name, category, price, quantity, status);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Object> getProductById(BigInteger id) {
        return productRepository.findById(id);
    }

    @Override
    public Product updateProduct(BigInteger id, String name, String category, Double price, Integer quantity, String status) {
        Optional<Object> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            Product product = (Product) existingProduct.get();
            product.setName(name);
            product.setCategory(Category.valueOf(category));
            product.setPrice(price);
            product.setQuantity(quantity);
            product.setStatus(Status.valueOf(status));
            return productRepository.save(product);
        }
        return null;
    }

    @Override
    public void deleteProduct(Integer id) {
        productRepository.deleteById(Long.valueOf(id));
    }
}
