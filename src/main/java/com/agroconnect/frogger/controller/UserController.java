package com.agroconnect.frogger.controller;

//import java.util.List;
//@CrossOrigin(origins = "*") // Allows all origins, or specify frontend URL
import com.agroconnect.frogger.entity.User;
import com.agroconnect.frogger.repository.UserRepository;
import com.agroconnect.frogger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

//    @PostMapping("/register")
//    public ResponseEntity<User> registerUser(@RequestBody User user) {
////        userRepository.save(user);
//
//        return ResponseEntity.ok((User) userService.registerUser(user));
//    }

//    @PostMapping("/register")
//    public ResponseEntity<String> registerUser(@RequestBody User user) {
//        try {
//            User savedUser = (User) userService.registerUser(user);
//            return ResponseEntity.ok("User registered successfully with ID: " + savedUser.getId());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving user: " + e.getMessage());
//        }
//    }

//            userRepository.save(user);
////            return ResponseEntity.ok("User saved successfully");
////            User savedUser = (User) userService.registerUser();
//            return ResponseEntity.ok("User registered successfully with ID: " + user.getId());

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
//            userRepository.save(user);
            userService.registerUser(user);
            return ResponseEntity.ok(user.getFirstName() + " " + user.getLastName()+" registered successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving user: " + e.getMessage());
        }
    }

    // Login User
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody User user) {

        try {
            userService.authenticateUser(user.getEmail(), user.getPassword());
            return ResponseEntity.ok("Login successful! Welcome " + user.getFirstName() + " " + user.getLastName());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials: " + e.getMessage());
        }
//        if (user != null) {
//            return ResponseEntity.ok("Login successful! Welcome " + user.getFirstName() + " " + user.getLastName());
//        } else {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
//        }
    }

    // Get All Users
    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    // Get User by ID
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable BigInteger id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    // Update User
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable BigInteger id, @RequestBody User updatedUser) {
        try {
            userService.updateUser(id, updatedUser);
            return ResponseEntity.ok("User updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating user: " + e.getMessage());
        }
    }

    // Update User Field
    @PatchMapping("/{id}")
    public ResponseEntity<String> patchUser(@PathVariable BigInteger id, @RequestBody Map<String, Object> updates) {
        try {
            userService.patchUser(id, updates);
            return ResponseEntity.ok("User updated successfully.");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // Delete User
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable BigInteger id) {
        try {
//            Optional<User> user = userService.getUserById(id);
            userService.deleteUser(id);
            return ResponseEntity.ok("User"+ id +" deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error deleting user: " + e.getMessage());
        }
    }


    @PostMapping("/test-register")
    public ResponseEntity<String> testRegisterUser() {
        User user = new User("John", "Doe", "john.ab@example.com", "password123", "CUSTOMER", "123 Main St", "Cityville", "State", "12345", "123-456-7890");
        userRepository.save(user);
        return ResponseEntity.ok("User saved successfully");
    }
}








