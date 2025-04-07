package com.agroconnect.frogger.service.impl;

import com.agroconnect.frogger.entity.User;
import com.agroconnect.frogger.factory.UserFactory;
import com.agroconnect.frogger.repository.UserRepository;
import com.agroconnect.frogger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserFactory userFactory, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        super(userFactory, userRepository, passwordEncoder);
    }

    @Override
    public User registerUser(String name, String email, String password, String role, String address, String postcode, String phoneNumber) {
        User user = new User(name, email, passwordEncoder.encode(password), role, address, postcode, phoneNumber);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(Long.valueOf(id));
    }

    @Override
    public User updateUser(Integer id, String name, String address, String postcode, String phoneNumber) {
        Optional<User> existingUser = userRepository.findById(Long.valueOf(id));
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setName(name);
            user.setAddress(address);
            user.setPostcode(postcode);
            user.setPhoneNumber(phoneNumber);
            return userRepository.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.deleteById(Long.valueOf(id));
    }
}
