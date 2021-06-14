package com.hospital.project.controllers;

import com.hospital.project.models.Test;
import com.hospital.project.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping
    public void saveTest(@RequestBody Test test) {
        testService.saveTest(test);
    }

    @GetMapping("/all")
    public Page<Test> getAllTests(@RequestParam(defaultValue = "0") Integer pageNo) {
        return testService.getAllTests(pageNo);
    }

    @DeleteMapping("/{testId}")
    public void deleteTest(@PathVariable Long testId) {
        testService.deleteById(testId);
    }

}
