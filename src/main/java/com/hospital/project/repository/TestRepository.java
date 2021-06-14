package com.hospital.project.repository;

import com.hospital.project.models.Test;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends PagingAndSortingRepository<Test, Long> {

}
