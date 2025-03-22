package com.agroconnect.frogger.service;

import com.agroconnect.frogger.entity.User;
import com.agroconnect.frogger.factory.UserFactory;
import com.agroconnect.frogger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class UserService {

    private final UserFactory userFactory;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserFactory userFactory, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userFactory = userFactory;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User registerUser(String name, String email, String password, String role, String address, String postcode, String phoneNumber) {
        String hashedPassword = passwordEncoder.encode(password);
        User user = userFactory.createUser(name, email, hashedPassword, role, address, postcode, phoneNumber);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(Long.valueOf(id));
    }

    public User updateUser(Integer id, String name, String address, String postcode, String phoneNumber) {
        User user = userRepository.findById(Long.valueOf(id))
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setName(name);
        user.setAddress(address);
        user.setPostcode(postcode);
        user.setPhoneNumber(phoneNumber);
        return userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(Long.valueOf(id));
    }

}

