package com.hospital.project.repository;

import com.hospital.project.models.Medicine;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicineRepository extends PagingAndSortingRepository<Medicine, Long> {

    Page<Medicine> findAll(Pageable pageable);

    Page<Medicine> findByMedicineNameContaining(String medicineName, Pageable pageable);

    Medicine findByMedicineName( String medicineName);

    Medicine findOneById( Long medicineId );
}
