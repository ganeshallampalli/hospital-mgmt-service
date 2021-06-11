package com.cts.project.repository;

import com.cts.project.models.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends PagingAndSortingRepository<Appointment, Long> {
    Page<Appointment> findByFirstNameOrDoctorNameLike( String firstName, String doctorName, Pageable page);
}
