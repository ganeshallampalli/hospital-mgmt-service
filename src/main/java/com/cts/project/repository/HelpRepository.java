package com.cts.project.repository;

import com.cts.project.models.Help;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelpRepository extends PagingAndSortingRepository<Help, Long> {

    @Override
    Page<Help> findAll(Pageable pageable);
}
