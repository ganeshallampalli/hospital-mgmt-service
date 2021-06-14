package com.hospital.project.repository;

import com.hospital.project.models.Booking;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface BookingRepository extends PagingAndSortingRepository<Booking, Long> {

    List<Booking> findAllByEmail(String email);

    List<Booking> findAll();

    List<Booking> findAllByAppointmentDate(Date date);

    // type in test
    List<Booking> findAllByTypeContaining(String testName);
}
