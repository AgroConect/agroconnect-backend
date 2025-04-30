package com.agroconnect.frogger.service.impl;

import com.agroconnect.frogger.entity.Category;
import com.agroconnect.frogger.entity.Product;
import com.agroconnect.frogger.entity.Status;
import com.agroconnect.frogger.entity.User;
import com.agroconnect.frogger.repository.ProductRepository;
import com.agroconnect.frogger.repository.UserRepository;
import com.agroconnect.frogger.service.ProductService;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

//    private final ProductRepository productRepository;
//    private final UserRepository userRepository;
//
//    @Autowired
//    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository) {
//        this.productRepository = productRepository;
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public Product addProduct(Product product, BigInteger farmerId) {
//        User farmer = userRepository.findById(farmerId)
//                .orElseThrow(() -> new NoSuchElementException("Farmer not found with ID: " + farmerId));
//
//        product.setFarmer(farmer); // ✅ Link actual User object to the product
//        return productRepository.save(product);
//    }
//
//    @Override
//    public List<Product> getAllProducts() {
//        return productRepository.findAll();
//    }
//
//    @Override
//    public Optional<Product> getProductById(BigInteger id) {
//        return productRepository.findById(id);
//    }
//
//    @Override
//    public void updateProduct(BigInteger id, Product updatedProduct, String currentUserEmail) {
//        Product existingProduct = productRepository.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Product not found"));
//
//        // Authorization check
//        if (!existingProduct.getFarmer().getEmail().equals(currentUserEmail) && !isAdmin(currentUserEmail)) {
//            throw new RuntimeException("Access denied: Not your product to update");
//        }
//
//        existingProduct.setImageUrl(updatedProduct.getImageUrl());
//        existingProduct.setName(updatedProduct.getName());
//        existingProduct.setCategory(updatedProduct.getCategory());
//        existingProduct.setPrice(updatedProduct.getPrice());
//        existingProduct.setQuantity(updatedProduct.getQuantity());
//        existingProduct.setStatus(updatedProduct.getStatus());
//
//        productRepository.save(existingProduct);
//    }
//
//    @Override
//    public Product patchProduct(BigInteger id, Map<String, Object> updates, String currentUserEmail) {
//        Product existingProduct = productRepository.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Product not found"));
//
//        // Authorization check
//        if (!existingProduct.getFarmer().getEmail().equals(currentUserEmail) && !isAdmin(currentUserEmail)) {
//            throw new RuntimeException("Access denied: Not your product to patch");
//        }
//
//        updates.forEach((key, value) -> {
//            switch (key) {
//                case "name": existingProduct.setName((String) value); break;
//                case "category": existingProduct.setCategory(Category.valueOf(((String) value).toUpperCase())); break;
//                case "price": existingProduct.setPrice(Double.valueOf(value.toString())); break;
//                case "quantity": existingProduct.setQuantity(Integer.valueOf(value.toString())); break;
//                case "status": existingProduct.setStatus(Status.valueOf(((String) value).toUpperCase())); break;
//                case "imageUrl": existingProduct.setImageUrl((String) value); break;
//                default:
//                    throw new IllegalArgumentException("Invalid field: " + key);
//            }
//        });
//
//        return productRepository.save(existingProduct);
//    }
//
//    @Override
//    public void deleteProduct(BigInteger id, String currentUserEmail) {
//        Product existingProduct = productRepository.findById(id)
//                .orElseThrow(() -> new NoSuchElementException("Product not found"));
//
//        // Authorization check
//        if (!existingProduct.getFarmer().getEmail().equals(currentUserEmail) && !isAdmin(currentUserEmail)) {
//            throw new RuntimeException("Access denied: Not your product to delete");
//        }
//
//        productRepository.deleteById(id);
//    }
//
//    private boolean isAdmin(String email) {
//        return userRepository.findByEmail(email)
//                .map(user -> user.getRole().name().equals("ADMIN"))
//                .orElse(false);
//    }
//
//
////    @Override
////    public void updateProduct(BigInteger id, Product updatedProduct) {
////        Product existingProduct = (Product) productRepository.findById(id)
////                .orElseThrow(() -> new NoSuchElementException("Product not found"));
////        existingProduct.setImageUrl(updatedProduct.getImageUrl());
////        existingProduct.setName(updatedProduct.getName());
////        existingProduct.setCategory(updatedProduct.getCategory());
////        existingProduct.setPrice(updatedProduct.getPrice());
////        existingProduct.setQuantity(updatedProduct.getQuantity());
////        existingProduct.setStatus(updatedProduct.getStatus());
////
////        productRepository.save(existingProduct);
////    }
////
////    @Override
////    public Product patchProduct(BigInteger id, Map<String, Object> updates) {
////        Product existingProduct = (Product) productRepository.findById(id)
////                .orElseThrow(() -> new NoSuchElementException("Product not found"));
////
////        updates.forEach((key, value) -> {
////            switch (key) {
////                case "name": existingProduct.setName((String) value); break;
////                case "category": existingProduct.setCategory(Category.valueOf(((String) value).toUpperCase())); break;
////                case "price": existingProduct.setPrice(Double.valueOf(value.toString())); break;
////                case "quantity": existingProduct.setQuantity(Integer.valueOf(value.toString())); break;
////                case "status": existingProduct.setStatus(Status.valueOf(((String) value).toUpperCase())); break;
////                case "imageUrl": existingProduct.setImageUrl((String) value); break;
////                default:
////                    throw new IllegalArgumentException("Invalid field: " + key);
////            }
////        });
////
////        return productRepository.save(existingProduct);
////    }
////
////    @Override
////    public void deleteProduct(BigInteger id) {
////        if (!productRepository.existsById(id)) {
////            throw new IllegalArgumentException("Product not found with id: " + id);
////        }
////        productRepository.deleteById(id);
////    }
//}
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, UserRepository userRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Product addProduct(Product product, BigInteger farmerId) {
        User farmer = userRepository.findById(farmerId)
                .orElseThrow(() -> new NoSuchElementException("Farmer not found with ID: " + farmerId));

        product.setFarmer(farmer);
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(BigInteger id) {
        return productRepository.findById(id);
    }

    @Override
    public void updateProduct(BigInteger id, Product updatedProduct, String currentUserEmail) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));

        User currentUser = userRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        if (!existingProduct.getFarmer().getId().equals(currentUser.getId()) &&
                !currentUser.getRole().name().equals("ADMIN")) {
            throw new RuntimeException("Access denied: Not your product to update");
        }

        existingProduct.setImageUrl(updatedProduct.getImageUrl());
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setCategory(updatedProduct.getCategory());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        existingProduct.setStatus(updatedProduct.getStatus());

        productRepository.save(existingProduct);
    }

    @Override
    public Product patchProduct(BigInteger id, Map<String, Object> updates, String currentUserEmail) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));

        User currentUser = userRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        if (!existingProduct.getFarmer().getId().equals(currentUser.getId()) &&
                !currentUser.getRole().name().equals("ADMIN")) {
            throw new RuntimeException("Access denied: Not your product to patch");
        }

        updates.forEach((key, value) -> {
            switch (key) {
                case "name" -> existingProduct.setName((String) value);
                case "category" -> existingProduct.setCategory(Category.valueOf(((String) value).toUpperCase()));
                case "price" -> existingProduct.setPrice(Double.valueOf(value.toString()));
                case "quantity" -> existingProduct.setQuantity(Integer.valueOf(value.toString()));
                case "status" -> existingProduct.setStatus(Status.valueOf(((String) value).toUpperCase()));
                case "imageUrl" -> existingProduct.setImageUrl((String) value);
                default -> throw new IllegalArgumentException("Invalid field: " + key);
            }
        });

        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(BigInteger id, String currentUserEmail) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));

        User currentUser = userRepository.findByEmail(currentUserEmail)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        if (!existingProduct.getFarmer().getId().equals(currentUser.getId()) &&
                !currentUser.getRole().name().equals("ADMIN")) {
            throw new RuntimeException("Access denied: Not your product to delete");
        }

        productRepository.deleteById(id);
    }

}