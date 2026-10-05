package com.prabha.ecommerce.controller;

import com.prabha.ecommerce.dto.*;
import com.prabha.ecommerce.entity.User;
import com.prabha.ecommerce.repository.UserRepository;
import com.prabha.ecommerce.security.JwtUtil;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return repo.save(user);
    }
    

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request) {

        User user = repo.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if (!user.getPassword()
                .equals(request.getPassword())) {

            throw new RuntimeException("Invalid password");
        }

        String token =
                jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(
                token,
                user.getRole(),
                user.getName(),
                user.getId()
        );
    }
}