package com.cts.project.service;

import com.cts.project.models.ChangePasswordRequest;
import com.cts.project.models.ERole;
import com.cts.project.models.User;
import com.cts.project.models.LoginRequest;
import com.cts.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    @PostConstruct
    public void addRoleAdmin() {
        List<User> users = new ArrayList<>();
        User adminUser = new User(
                1L, "admin", "admin", ERole.ROLE_ADMIN, "admin", "admin", new Date(),
                9999999999L, "Male", null, null, null, null,
                null, null, null, null, null,
                "admin@gmail.com", "", "");

        users.add(adminUser);

//        User doctorUser = new User(
//                1L, "doctor", "doctor", ERole.ROLE_DOCTOR, "doctor", "doctor", new Date(),
//                9999999999L, "Male", null, null, null, null,
//                null, null, null, null, null,
//                "doctor@gmail.com", "", "");
//        users.add(doctorUser);
        userRepository.saveAll(users);
    }

    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) throws Exception {
        User user = userRepository.findOneByUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            throw new Exception("Not able to find the user");
        }
    }

    public ResponseEntity<?> changePassword(ChangePasswordRequest changePasswordRequest) {
        Optional<User> user = userRepository.findById(changePasswordRequest.getId());
        if (user.isPresent()) {
            User userObject = user.get();
            if (userObject.getPassword().equals(changePasswordRequest.getCurrentPassword())) {
                userObject.setPassword(changePasswordRequest.getNewPassword());
                userRepository.save(userObject);
                return ResponseEntity.ok("Password changed Successfully");
            } else {
                return ResponseEntity.ok("Invalid Current Password");
            }
        } else {
            return ResponseEntity.ok("User Not Found");
        }
    }
}
