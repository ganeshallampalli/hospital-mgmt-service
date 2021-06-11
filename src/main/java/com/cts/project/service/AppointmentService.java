package com.cts.project.service;

import com.cts.project.models.Appointment;
import com.cts.project.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    AppointmentRepository appointmentRepository;

    public Page<Appointment> getAllAppointments(Integer pageNo) {
        Pageable page = PageRequest.of(pageNo, 5);
        return appointmentRepository.findAll(page);

    }

    public Page<Appointment> getUserByUserId(String firstName, String doctorName, Integer pageNo) {
        Pageable page = PageRequest.of(pageNo, 5);
        if (("").equals(firstName) && ("").equals(doctorName)) {
            return appointmentRepository.findAll(page);
        } else {
            return appointmentRepository.findByFirstNameOrDoctorNameLike(firstName, doctorName, page);
        }
    }

    public Appointment getAppointmentByAppointmentId(Long appointmentId) {
        Optional<Appointment> appointment = appointmentRepository.findById(appointmentId);
        if (appointment.isPresent()) {
            return appointment.get();
        } else return null;
    }

    public void addAppointment(Appointment appointment) {
        appointmentRepository.save(appointment);
    }

    public void addAppointment(Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

}
