package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.User;

public interface UserFactory {
    User createUser(String name, String email, String password, String role, String address, String postcode, String phoneNumber);
}
