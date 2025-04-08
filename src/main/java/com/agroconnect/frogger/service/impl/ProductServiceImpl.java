package com.agroconnect.frogger.service.impl;

import com.agroconnect.frogger.entity.Category;
import com.agroconnect.frogger.entity.Product;
import com.agroconnect.frogger.entity.Status;
import com.agroconnect.frogger.factory.ProductFactory;
import com.agroconnect.frogger.repository.ProductRepository;
import com.agroconnect.frogger.repository.UserRepository;
import com.agroconnect.frogger.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Map;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository; // Inject UserRepository

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;  // Ensure it's injected here
    }

    @Override
    public Product addProduct(Product product) {
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
    public void updateProduct(BigInteger id, Product updatedProduct) {
        Product existingProduct = (Product) productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setCategory(updatedProduct.getCategory());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        existingProduct.setStatus(updatedProduct.getStatus());

        productRepository.save(existingProduct);
    }

    @Override
    public Product patchProduct(BigInteger id, Map<String, Object> updates) {
        Product existingProduct = (Product) productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));

        updates.forEach((key, value) -> {
            switch (key) {
                case "name": existingProduct.setName((String) value); break;
                case "category": existingProduct.setCategory(Category.valueOf(((String) value).toUpperCase())); break;
                case "price": existingProduct.setPrice(Double.valueOf(value.toString())); break;
                case "quantity": existingProduct.setQuantity(Integer.valueOf(value.toString())); break;
                case "status": existingProduct.setStatus(Status.valueOf(((String) value).toUpperCase())); break;
                default:
                    throw new IllegalArgumentException("Invalid field: " + key);
            }
        });

        productRepository.save(existingProduct);
        return existingProduct;
    }


    @Override
    public void deleteProduct(BigInteger id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalArgumentException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }
}
