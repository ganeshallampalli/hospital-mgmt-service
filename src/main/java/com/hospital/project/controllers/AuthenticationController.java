package com.hospital.project.controllers;

import com.hospital.project.models.ChangePasswordRequest;
import com.hospital.project.models.LoginRequest;
import com.hospital.project.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/login")
public class AuthenticationController {

    @Autowired
    AuthService authService;

    @PostMapping
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) throws Exception {
        return authService.authenticateUser(loginRequest);
    }

    @PostMapping("/change-password")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest) {
        return authService.changePassword(changePasswordRequest);
    }
}
