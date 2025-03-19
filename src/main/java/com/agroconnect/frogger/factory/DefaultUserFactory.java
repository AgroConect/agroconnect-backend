package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.Role;
import com.agroconnect.frogger.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class DefaultUserFactory implements UserFactory {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User createUser(String name, String email, String password, String role, String address, String postcode, String phoneNumber) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password)); // Hash the password
        user.setRole(Role.valueOf(role));

        // Set default values based on the role
        if ("farmer".equals(role)) {
            user.setAddress("Default Farmer Address");
            user.setPostcode("00000");
            user.setPhoneNumber("0000000000");
        } else if ("customer".equals(role)) {
            user.setAddress("Default Customer Address");
            user.setPostcode("00001");
            user.setPhoneNumber("1111111111");
        } else if ("deliveryman".equals(role)) {
            user.setAddress("Default Delivery Address");
            user.setPostcode("00002");
            user.setPhoneNumber("2222222222");
        }

        return user;
    }

}