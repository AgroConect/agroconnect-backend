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
    public User createUser(String firstname, String lastname, String email, String password, String role, String street, String city, String state, String postcode, String phoneNumber) {
        User user = new User();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password)); // Hash the password
        user.setRole(Role.valueOf(role.toUpperCase()));

        // Set default values based on the role
        if ("farmer".equals(role)) {
            user.setStreet("Default Farmer Street");
            user.setCity("Default Farmer City");
            user.setState("Default Farmer State");
            user.setPostcode("00000");
            user.setPhoneNumber("0000000000");
        } else if ("customer".equals(role)) {
            user.setStreet("Default Customer Street");
            user.setCity("Default Customer City");
            user.setState("Default Customer State");
            user.setPostcode("00001");
            user.setPhoneNumber("1111111111");
        } else if ("deliveryman".equals(role)) {
            user.setStreet("Default Delivery Street");
            user.setCity("Default Delivery City");
            user.setState("Default Delivery State");
            user.setPostcode("00002");
            user.setPhoneNumber("2222222222");
        }

        return user;
    }

//    @Override
//    public User createUser(String firstname, String lastname, String email, String password, String role, String street, String city, String state, String postcode, String phoneNumber) {
//        return null;
//    }
}