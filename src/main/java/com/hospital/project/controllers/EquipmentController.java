package com.hospital.project.controllers;

import com.hospital.project.models.Equipment;
import com.hospital.project.models.EquipmentRequest;
import com.hospital.project.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/equipment")
public class EquipmentController {

    @Autowired
    EquipmentService equipmentService;

    @PostMapping
    public void addEquipment(@RequestBody EquipmentRequest equipmentRequest) {
        equipmentService.saveEquipment(equipmentRequest);
    }

    @GetMapping("/all")
    public List<EquipmentRequest> getAllEquipments() {
        return equipmentService.getEquipments();
    }

}
