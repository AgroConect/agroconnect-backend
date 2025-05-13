package com.agroconnect.frogger.service;

import com.agroconnect.frogger.entity.Role;
import com.agroconnect.frogger.entity.User;
import com.agroconnect.frogger.repository.UserRepository;
import com.agroconnect.frogger.service.impl.UserServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private org.springframework.security.crypto.password.PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void authenticateUser_shouldSucceed_whenCredentialsAreCorrect() {
        // Arrange
        String email = "test@example.com";
        String rawPassword = "12345";
        String hashedPassword = "hashed";

        User user = new User();
        user.setEmail(email);
        user.setPassword(hashedPassword);

        when(userRepository.findByEmail(email)).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(rawPassword, hashedPassword)).thenReturn(true);

        // Act & Assert
        assertDoesNotThrow(() -> userService.authenticateUser(email, rawPassword));
    }

    @Test
    void authenticateUser_shouldThrowException_whenUserNotFound() {
        when(userRepository.findByEmail("missing@example.com")).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () ->
                userService.authenticateUser("missing@example.com", "12345")
        );

        assertEquals("User not found", exception.getMessage());
    }

    @Test
    void authenticateUser_shouldThrowException_whenPasswordInvalid() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword(passwordEncoder.encode("correctPassword")); // hashed correct password

        when(userRepository.findByEmail("test@example.com")).thenReturn(Optional.of(user));

        RuntimeException exception = assertThrows(RuntimeException.class, () ->
                userService.authenticateUser("test@example.com", "wrongPassword"));

        assertEquals("Invalid credentials", exception.getMessage());
    }
 }
