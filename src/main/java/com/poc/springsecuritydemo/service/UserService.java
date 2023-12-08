package com.poc.springsecuritydemo.service;

import com.poc.springsecuritydemo.dto.UserDTO;
import com.poc.springsecuritydemo.entity.User;

public interface UserService {
    User registerUser(UserDTO userDTO) throws Exception;

    void saveVerificationTokenForUser(String token, User user);
}
