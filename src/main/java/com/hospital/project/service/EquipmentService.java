package com.hospital.project.service;

import com.hospital.project.models.Equipment;
import com.hospital.project.models.EquipmentRequest;
import com.hospital.project.repository.EquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Service
public class EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    public void saveEquipment(EquipmentRequest equipmentRequest) {

        byte[] image = equipmentRequest.getImage().getBytes(StandardCharsets.UTF_8);
        Equipment equipment = new Equipment();
        equipment.setImage(image);
        equipment.setName(equipmentRequest.getName());
        equipmentRepository.save(equipment);
    }

    public List<EquipmentRequest> getEquipments() {

        List<EquipmentRequest> equipmentRequests = new ArrayList<>();
        List<Equipment> equipments = equipmentRepository.findAll();
        equipments.stream().forEach(equipment -> {
            EquipmentRequest equipmentRequest = new EquipmentRequest();
            equipmentRequest.setImage(new String(equipment.getImage()));
            equipmentRequest.setName(equipment.getName());
            equipmentRequests.add(equipmentRequest);
        });
        return equipmentRequests;

    }
}
