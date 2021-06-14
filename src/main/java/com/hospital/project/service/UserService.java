package com.hospital.project.service;

import com.hospital.project.models.ERole;
import com.hospital.project.models.User;
import com.hospital.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Page<User> getAllUsers(Integer pageNo) {
        Pageable page = PageRequest.of(pageNo, 5);
        return userRepository.findAll(page);
    }

//    public Page<User> getAllDoctors(Integer pageNo) {
//        Pageable page = PageRequest.of(pageNo, 5);
//        return userRepository.findAllByRole(ERole.ROLE_DOCTOR, page);
//    }
//
//    public Page<User> getAllReception(Integer pageNo) {
//        Pageable page = PageRequest.of(pageNo, 5);
//        return userRepository.findAllByRole(ERole.ROLE_RECEPTION, page);
//    }
//
//    public Page<User> getAllPatient(Integer pageNo) {
//        Pageable page = PageRequest.of(pageNo, 5);
//        return userRepository.findAllByRole(ERole.ROLE_PATIENT, page);
//    }

    public User getUserByUserId(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent()) {
            return user.get();
        } else return null;
    }

//    public Page<User> getUserByUserId(String firstName, String emailId,
//                                      Integer pageNo,
//                                      ERole role
//    ) {
//        Pageable page = PageRequest.of(pageNo, 5);
//        if (("").equals(firstName) && ("").equals(emailId)) {
//            return userRepository.findAllByRole(role, page);
//        } else {
//            return userRepository.findByRoleAndFirstNameOrEmailIdLike(role, firstName, emailId, page);
//        }
//    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void addUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
