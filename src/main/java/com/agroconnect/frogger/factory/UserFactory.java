package com.agroconnect.frogger.factory;

import com.agroconnect.frogger.entity.User;

public interface UserFactory {

    User createUser(String firstname, String lastname, String email, String password, String role, String street, String city, String state, String postcode, String phoneNumber);
}
