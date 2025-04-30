package com.agroconnect.frogger.controller;

import com.agroconnect.frogger.entity.Category;
import com.agroconnect.frogger.entity.Product;
import com.agroconnect.frogger.entity.Status;
import com.agroconnect.frogger.entity.User;
import com.agroconnect.frogger.repository.UserRepository;
import com.agroconnect.frogger.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    private UserRepository userRepository;

    @PostMapping("/add-products")
    public ResponseEntity<?> addProduct(@RequestBody Map<String, Object> payload) {
        try {
            BigInteger farmerId = new BigInteger(payload.get("farmerId").toString());

            Product product = new Product();
            product.setName(payload.get("name").toString());
            product.setCategory(Category.fromString(payload.get("category").toString()));
            product.setPrice(Double.valueOf(payload.get("price").toString()));
            product.setQuantity(Integer.valueOf(payload.get("quantity").toString()));
            product.setStatus(Status.fromString(payload.get("status").toString()));

            Product savedProduct = productService.addProduct(product, farmerId);

            // ✅ Return a success message instead of serializing the raw entity
            return ResponseEntity.ok("Product saved successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error saving product: " + e.getMessage());
        }
    }
//    public ResponseEntity<String> addProduct(Product product, BigInteger farmerId) {
//        // Assuming you're associating a farmer with the product
//        Optional<User> farmer = userRepository.findById(product.getFarmer());
//        if (farmer.isPresent()) {
//            product.setFarmer(farmer); // Associate the farmer with the product
//            productService.addProduct(product, farmerId);
//            return ResponseEntity.ok(product.getName()+ "Added successfully");
////            return productRepository.save(product);
////            Product savedProduct = productService.addProduct(product);
////            return ResponseEntity.ok(savedProduct);
//        } else {
//            throw new NoSuchElementException("Farmer not found for id: " + product.getFarmerId());
//        }
//    }
//    public ResponseEntity<?> addProduct(@RequestBody Product product) {
//        try {
//            // Check if farmer exists before assigning
////            if (product.getFarmerId() == null) {
////                return ResponseEntity.badRequest().body("Farmer ID is required");
////            }
//
//            // Fetch the Farmer entity from the database
//            User farmer = userRepository.findById(product.getFarmerId())
//                    .orElseThrow(() -> new NoSuchElementException("Farmer not found"));
//
//            // Assign the Farmer object to the Product
//            product.setFarmerId(farmer.getId());
//
//            // Save the product
//            Product savedProduct = productService.addProduct(product);
//            return ResponseEntity.ok(savedProduct);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("Error saving product: " + e.getMessage());
//        }
//    }
//    public ResponseEntity<?> addProduct(@RequestBody Map<String, Object> productData) {
//        try {
//            BigInteger farmerId = new BigInteger(productData.get("farmerId").toString());
//            User farmer = userRepository.findById(farmerId)
//                    .orElseThrow(() -> new NoSuchElementException("Farmer not found"));
//
//            Product product = new Product();
//            product.setName((String) productData.get("name"));
//            product.setCategory(Category.valueOf((String) productData.get("category")));
//            product.setPrice(Double.parseDouble(productData.get("price").toString()));
//            product.setQuantity(Integer.parseInt(productData.get("quantity").toString()));
//            product.setStatus(Status.valueOf((String) productData.get("status")));
//            product.setFarmerId(farmer.getId()); // Set the farmer
//
//            Product savedProduct = productService.addProduct(product);
//            return ResponseEntity.ok(savedProduct);
//
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
//        }
//    }
//    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
//        return ResponseEntity.ok((Product) productService.addProduct(product));
//    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable BigInteger id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable BigInteger id, @RequestBody Product updatedProduct) {
        try {
            productService.updateProduct(id, updatedProduct);
            return ResponseEntity.ok("Product updated successfully");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Product not found");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating product: " + e.getMessage());
        }
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Product> patchProduct(@PathVariable BigInteger id, @RequestBody Map<String, Object> updates) {
        return ResponseEntity.ok(productService.patchProduct(id, updates));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable BigInteger id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("Product deleted successfully.");
    }
}
