package com.cts.project.controllers;

import com.cts.project.models.Help;
import com.cts.project.service.HelpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/help")
public class HelpController {

    @Autowired
    HelpService helpService;

    @GetMapping("/all")
    public Page<Help> getAllHelps(@RequestParam(defaultValue = "0") Integer pageNo) {
        return helpService.getAllHelps(pageNo);
    }

    @PostMapping
    public void saveHelp(@RequestBody Help help) {
        helpService.saveHelp(help);
    }

    @DeleteMapping("/{helpId}")
    public void deleteHelp(@PathVariable Long helpId) {
        helpService.deleteHelp(helpId);
    }
}
