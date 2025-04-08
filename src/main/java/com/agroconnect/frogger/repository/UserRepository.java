package com.agroconnect.frogger.repository;

import com.agroconnect.frogger.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, BigInteger> {
    Optional<User> findByEmail(String email);  // Find user by email

    Optional<User> findById(BigInteger id); // Ensure this matches the id type in the entity

    void deleteById(BigInteger id);
}
