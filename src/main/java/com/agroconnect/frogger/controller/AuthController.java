package com.agroconnect.frogger.controller;

import com.agroconnect.frogger.entity.Role;
import com.agroconnect.frogger.entity.User;
import com.agroconnect.frogger.repository.UserRepository;
import com.agroconnect.frogger.security.JwtUtil;
import com.agroconnect.frogger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;


    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
//            user.setRole(Role.valueOf(user.getRole().toUpperCase()));
            User savedUser = userService.registerUser(user);
            String token = jwtUtil.generateToken(savedUser);

            Map<String, Object> response = new HashMap<>();
            response.put("message", savedUser.getFirstName() + " " + savedUser.getLastName() + " registered successfully");
            response.put("token", token);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Collections.singletonMap("error", "Error saving user: " + e.getMessage()));
        }
    }

    // Login
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
//        Authentication auth = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword())
//        );
//
//        User user = userRepository.findByEmail(authRequest.getEmail()).orElseThrow();
//        String token = jwtUtil.generateToken(user);
//
//        return ResponseEntity.ok(new AuthResponse(token, user.getRole()));
//    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> loginUser(@RequestBody User loginRequest) {
        Map<String, Object> response = new HashMap<>();

        try {
            userService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());

            // Get the full user from database
            User fullUser = userService.getUserByEmail(loginRequest.getEmail());

            String token = jwtUtil.generateToken(fullUser);

            response.put("token", token);
            response.put("message", "Login successful! Welcome " + fullUser.getFirstName() + " " + fullUser.getLastName());

            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("error", "Invalid credentials: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }


//    // Login User
//    @PostMapping("/login")
//    public ResponseEntity<String> loginUser(@RequestBody User user) {
//
//        try {
//            userService.authenticateUser(user.getEmail(), user.getPassword());
//            return ResponseEntity.ok("Login successful! Welcome " + user.getFirstName() + " " + user.getLastName());
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials: " + e.getMessage());
//        }
//    }
}
