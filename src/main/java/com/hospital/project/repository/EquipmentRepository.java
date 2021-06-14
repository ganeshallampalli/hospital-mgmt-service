package com.hospital.project.repository;

import com.hospital.project.models.Equipment;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipmentRepository extends PagingAndSortingRepository<Equipment, Long> {

    List<Equipment> findAll();
}
