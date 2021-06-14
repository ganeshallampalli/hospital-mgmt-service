package com.hospital.project.controllers;

import com.hospital.project.models.Medicine;
import com.hospital.project.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/medicine")
public class MedicineController {

    @Autowired
    MedicineService medicineService;

    @GetMapping("/all")
    public Page<Medicine> getMedicines(@RequestParam(defaultValue = "0") Integer pageNo) {
        return medicineService.getMedicines(pageNo);
    }

    @GetMapping("/{medicineId}")
    public Medicine getMedicine(@PathVariable("medicineId") Long medicineId) {
        return medicineService.getMedicine( medicineId );
    }

    @GetMapping("/search")
    public Page<Medicine> searchMedicine(@RequestParam String medicineName,
                                         @RequestParam(defaultValue = "0") Integer pageNo ) {

        if (medicineName.trim().isEmpty()) {
            return Page.empty();
        }
        return medicineService.searchMedicine(medicineName, pageNo);
    }

    @DeleteMapping("/{medicineId}")
    public void deleteMedicine(@PathVariable("medicineId") Long medicineId) {
        medicineService.deleteMedicine( medicineId );
    }

    @PostMapping
    public void saveMedicine(@RequestBody Medicine medicine) {
        medicineService.saveMedicine( medicine );
    }
}
