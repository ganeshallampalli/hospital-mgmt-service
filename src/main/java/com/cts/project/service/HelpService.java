package com.cts.project.service;

import com.cts.project.models.Help;
import com.cts.project.repository.HelpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HelpService {

    @Autowired
    HelpRepository helpRepository;

    public Page<Help> getAllHelps( Integer pageNo ) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        return helpRepository.findAll(pageable);
    }

    public void saveHelp( Help help ) {
        helpRepository.save( help );
    }

    public void deleteHelp(Long helpId) {
        helpRepository.deleteById(helpId);
    }
}
