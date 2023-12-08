package com.poc.springsecuritydemo.entity.listener;

import com.poc.springsecuritydemo.entity.User;
import com.poc.springsecuritydemo.event.RegistrationCompleteEvent;
import com.poc.springsecuritydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {
    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        String url = event.getApplicationUrl() + "/verifyRegistration?token=" + token;
//        Mocking to send email
        System.out.println("Click the link to verify your account:" + url);
    }
}