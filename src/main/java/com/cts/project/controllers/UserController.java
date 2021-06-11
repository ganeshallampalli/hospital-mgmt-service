package com.cts.project.controllers;

import com.cts.project.models.ERole;
import com.cts.project.models.User;
import com.cts.project.repository.UserRepository;
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

    @GetMapping("/all/doctor")
    public Page<User> getAllDoctors(@RequestParam(defaultValue = "0") Integer pageNo) {
        Pageable page = PageRequest.of(pageNo, 5);
        return userRepository.findAllByRole(ERole.ROLE_DOCTOR, page);
    }

    @GetMapping("/all/reception")
    public Page<User> getAllReception(@RequestParam(defaultValue = "0") Integer pageNo) {
        Pageable page = PageRequest.of(pageNo, 5);
        return userRepository.findAllByRole(ERole.ROLE_RECEPTION, page);
    }

    @GetMapping("/all/patient")
    public Page<User> getAllPatient(@RequestParam(defaultValue = "0") Integer pageNo) {
        Pageable page = PageRequest.of(pageNo, 5);
        return userRepository.findAllByRole(ERole.ROLE_PATIENT, page);
    }

    @GetMapping("/{userId}")
    public User getUserByUserId(@PathVariable Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else return null;
    }

    @GetMapping("/search")
    public Page<User> getUserByUserId(@RequestParam String firstName, @RequestParam String emailId,
                                      @RequestParam(defaultValue = "0") Integer pageNo,
                                      @RequestParam ERole role
    ) {
        Pageable page = PageRequest.of(pageNo, 5);
        if (("").equals(firstName) && ("").equals(emailId)) {
            return userRepository.findAllByRole(role, page);
        } else {
            return userRepository.findByRoleAndFirstNameOrEmailIdLike(role, firstName, emailId, page);
        }
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @DeleteMapping("/{userId}")
    public void addUser(@PathVariable Long userId) {
        userRepository.deleteById(userId);
    }
}
