package com.agroconnect.frogger.service;

import com.agroconnect.frogger.entity.User;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(BigInteger id);

    void authenticateUser(String email, String password);

    void deleteUser(BigInteger id);

    void registerUser(User user);

    void updateUser(BigInteger id, User updatedUser);

    void patchUser(BigInteger id, Map<String, Object> updates);

}

