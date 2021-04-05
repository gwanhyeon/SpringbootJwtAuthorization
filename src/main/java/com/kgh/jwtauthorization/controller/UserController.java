package com.kgh.jwtauthorization.controller;

import com.kgh.jwtauthorization.exception.ResourceNotFoundException;
import com.kgh.jwtauthorization.model.User;
import com.kgh.jwtauthorization.repository.UserRepository;
import com.kgh.jwtauthorization.security.CurrentUser;
import com.kgh.jwtauthorization.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public User getCurrentUser(@CurrentUser UserPrincipal userPrincipal) {
        return userRepository.findById(userPrincipal.getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userPrincipal.getId()));
    }
}
