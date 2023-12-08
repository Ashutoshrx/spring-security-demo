package com.poc.springsecuritydemo.service.impl;

import com.poc.springsecuritydemo.dto.UserDTO;
import com.poc.springsecuritydemo.entity.User;
import com.poc.springsecuritydemo.entity.VerificationToken;
import com.poc.springsecuritydemo.repository.UserRepository;
import com.poc.springsecuritydemo.repository.VerificationTokenRepository;
import com.poc.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Override
    public User registerUser(UserDTO userDTO) {
        try {
            User user = new User();
            user.setEmail(userDTO.getEmail());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setRole("USER");
            user.setRole("USER");
            user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userRepository.save(user);
            return user;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken = new VerificationToken(token, user);
        verificationTokenRepository.save(verificationToken);
    }
}
