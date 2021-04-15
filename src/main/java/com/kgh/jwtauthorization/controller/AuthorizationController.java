package com.kgh.jwtauthorization.controller;

import com.kgh.jwtauthorization.model.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
class AuthorizationController {
    @GetMapping("/testtest")
    public User asdasd(@AuthenticationPrincipal User user, @RequestHeader("Authorization") String authorization ) {
        System.err.println("authorization = " + authorization);
        System.err.println("user = " + user);
        return user;
    }
}
