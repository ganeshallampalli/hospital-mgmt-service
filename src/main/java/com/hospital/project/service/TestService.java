package com.hospital.project.service;

import com.hospital.project.models.Test;
import com.hospital.project.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TestService {

    @Autowired
    private TestRepository testRepository;

    public void saveTest(Test test) {
        testRepository.save(test);
    }

    public Page<Test> getAllTests(Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        return testRepository.findAll(pageable);
    }


    public void deleteById(Long testId) {
        testRepository.deleteById(testId);
    }
}
