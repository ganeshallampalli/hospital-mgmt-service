package com.hospital.project.controllers;

import com.hospital.project.models.ERole;
import com.hospital.project.models.User;
import com.hospital.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/all")
    public Page<User> getAllUsers(@RequestParam(defaultValue = "0") Integer pageNo) {
        Pageable page = PageRequest.of(pageNo, 5);
        return userRepository.findAll(page);

    }


    @GetMapping("/all/customer")
    public Page<User> getAllDoctors(@RequestParam(defaultValue = "0") Integer pageNo) {
        Pageable page = PageRequest.of(pageNo, 5);
        return userRepository.findAllByRole(ERole.ROLE_CUSTOMER, page);
    }

    @GetMapping("/all/technician")
    public Page<User> getAllReception(@RequestParam(defaultValue = "0") Integer pageNo) {
        Pageable page = PageRequest.of(pageNo, 5);
        return userRepository.findAllByRole(ERole.ROLE_TECHNICIAN, page);
    }

    @GetMapping("/{userId}")
    public User getUserByUserId(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else return null;
    }


    @PostMapping("/signup")
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @DeleteMapping("/{userId}")
    public void addUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }
}
