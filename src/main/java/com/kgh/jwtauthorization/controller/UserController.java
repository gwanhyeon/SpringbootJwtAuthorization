package com.kgh.jwtauthorization.controller;

import com.kgh.jwtauthorization.exception.ResourceNotFoundException;
import com.kgh.jwtauthorization.model.User;
import com.kgh.jwtauthorization.repository.UserRepository;
import com.kgh.jwtauthorization.security.CurrentUser;
import com.kgh.jwtauthorization.security.TokenProvider;
import com.kgh.jwtauthorization.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        String token = tokenProvider.getToken();
        System.err.println("token = " + token);
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
    @GetMapping("/user/token")
    public String getUserToken(@AuthenticationPrincipal User user, @RequestHeader("Authorization") String authorization) {
        System.err.println("authorization = " + authorization);
        System.err.println("user = " + user);
        return authorization;
    }
}
