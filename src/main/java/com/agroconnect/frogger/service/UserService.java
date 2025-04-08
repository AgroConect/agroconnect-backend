package com.agroconnect.frogger.service;

import com.agroconnect.frogger.entity.User;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service

public interface UserService {

//    User registerUser(String firstname, String lastname, String email, String password, String role, String street, String city, String state, String postcode, String phoneNumber);

    List<User> getAllUsers();

    Optional<User> getUserById(BigInteger id);

    void authenticateUser(String email, String password);

//    User updateUser(BigInteger id, String firstname, String lastname, String street, String city, String state, String postcode, String phoneNumber);
    
    void deleteUser(BigInteger id);

    void registerUser(User user);

    void updateUser(BigInteger id, User updatedUser);

    void patchUser(BigInteger id, Map<String, Object> updates);

//    Object registerUser(User user);


}

