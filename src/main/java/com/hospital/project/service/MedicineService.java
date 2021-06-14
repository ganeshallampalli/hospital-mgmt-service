package com.hospital.project.service;

import com.hospital.project.models.Medicine;
import com.hospital.project.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MedicineService {

    @Autowired
    MedicineRepository medicineRepository;

    public Page<Medicine> getMedicines( Integer pageNo ) {
        Pageable page = PageRequest.of(pageNo, 5);
        return medicineRepository.findAll(page);
    }

    public Page<Medicine> searchMedicine( String medicineName, Integer pageNo ) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        return medicineRepository.findByMedicineNameContaining(medicineName, pageable);
    }

    public void deleteMedicine( Long medicineId ) {
        medicineRepository.deleteById(medicineId);
    }

    public Medicine findMedicineByName( String medicineName) {
        return medicineRepository.findByMedicineName(medicineName);
    }

    public void saveMedicine(Medicine medicine) {
        medicineRepository.save( medicine );
    }

    public Medicine getMedicine( Long medicineId) {
        return medicineRepository.findOneById( medicineId );
    }
}

