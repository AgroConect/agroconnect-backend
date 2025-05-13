package com.agroconnect.frogger.service.impl;

import com.agroconnect.frogger.entity.Role;
import com.agroconnect.frogger.entity.User;
import com.agroconnect.frogger.repository.UserRepository;
import com.agroconnect.frogger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(BigInteger id) {
        return userRepository.findById(id);
    }


    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public Optional<User> getFirstName(String firstname) {
        return userRepository.findByFirstname(firstname);
    }

    @Override
    public Optional<User> getLastName(String lastname) {
        return userRepository.findByLastname(lastname);
    }

    @Override
    public void authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
    }

//    @Override
//    public void authenticateUser(String email, String password) {
//        Optional<User> userOptional = userRepository.findByEmail(email);
//
//        if (userOptional.isPresent()) {
//            User user = userOptional.get();
//            System.out.println("User Found: " + user.getFirstName() + " " + user.getLastName()); // Debugging
//
//            if (passwordEncoder.matches(password, user.getPassword())) {
//                return user; // Successfully authenticated
//            } else {
//                System.out.println("Incorrect password"); // Debugging
//            }
//        } else {
//            System.out.println("User not found with email: " + email); // Debugging
//        }
//
//        return null; // Authentication failed
//    }


    @Override
    public void deleteUser(BigInteger id) {
        userRepository.deleteById(id);
    }

    @Override
    public User registerUser(User user) {
        // Ensure role is stored as uppercase
        user.setRole(Role.fromString(user.getRole().name()));
        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Save user to the database
        userRepository.save(user);
        return user;
    }

    @Override
    public void updateUser(BigInteger id, User updatedUser) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        existingUser.setFirstName(updatedUser.getFirstName());
        existingUser.setLastName(updatedUser.getLastName());
        existingUser.setEmail(updatedUser.getEmail());
        existingUser.setPassword(passwordEncoder.encode(updatedUser.getPassword()));
        existingUser.setRole(updatedUser.getRole());
        existingUser.setStreet(updatedUser.getStreet());
        existingUser.setCity(updatedUser.getCity());
        existingUser.setState(updatedUser.getState());
        existingUser.setPostcode(updatedUser.getPostcode());
        existingUser.setPhoneNumber(updatedUser.getPhoneNumber());

        userRepository.save(existingUser);
    }

    @Override
    public void patchUser(BigInteger id, Map<String, Object> updates) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        updates.forEach((key, value) -> {
            switch (key) {
                case "firstName": existingUser.setFirstName((String) value); break;
                case "lastName": existingUser.setLastName((String) value); break;
                case "email": existingUser.setEmail((String) value); break;
                case "password": existingUser.setPassword(passwordEncoder.encode((String) value)); break;
                case "role": existingUser.setRole(Role.valueOf((String) value)); break;
                case "street": existingUser.setStreet((String) value); break;
                case "city": existingUser.setCity((String) value); break;
                case "state": existingUser.setState((String) value); break;
                case "postcode": existingUser.setPostcode((String) value); break;
                case "phoneNumber": existingUser.setPhoneNumber((String) value); break;
                default:
                    throw new IllegalArgumentException("Invalid field: " + key);
            }
        });

        userRepository.save(existingUser);
    }
}
