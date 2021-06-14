package com.hospital.project.service;

import com.hospital.project.models.ChangePasswordRequest;
import com.hospital.project.models.ERole;
import com.hospital.project.models.User;
import com.hospital.project.models.LoginRequest;
import com.hospital.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
        User adminUser =
                new User(1L, "ADMI1234", "admin", "admin@gmail.com", "admin", "Bangalore", 9999999999L, ERole.ROLE_ADMIN, new Date(), new Date());

        users.add(adminUser);

        userRepository.saveAll(users);
    }

    public ResponseEntity<?> authenticateUser(LoginRequest loginRequest) throws Exception {
        User user = userRepository.findOneByEmailAndPassword(loginRequest.getEmail(), loginRequest.getPassword());
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
