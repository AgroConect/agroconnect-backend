package com.agroconnect.frogger.repository;

import com.agroconnect.frogger.entity.Category;
import com.agroconnect.frogger.entity.Product;
import com.agroconnect.frogger.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);  // Get products by category
    List<Product> findByStatus(Status status);      // Get available products
    List<Product> findByFarmerId(BigInteger farmerId);

    Optional<Object> findById(BigInteger productId);
}