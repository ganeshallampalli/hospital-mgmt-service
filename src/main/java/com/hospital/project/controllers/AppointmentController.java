package com.hospital.project.controllers;

import com.hospital.project.models.Appointment;
import com.hospital.project.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentController {
    @Autowired
    AppointmentService appointmentRepository;

    @GetMapping("/all")
    public Page<Appointment> getAllAppointments(@RequestParam(defaultValue = "0") Integer pageNo) {
        return appointmentRepository.getAllAppointments(pageNo);

    }

    @GetMapping("/search")
    public Page<Appointment> getUserByUserId(@RequestParam String firstName, @RequestParam String doctorName,
                                             @RequestParam(defaultValue = "0") Integer pageNo) {
        return appointmentRepository.getUserByUserId(firstName, doctorName, pageNo);
    }

    @GetMapping("/{appointmentId}")
    public Appointment getAppointmentByAppointmentId(@PathVariable Long appointmentId) {
        return appointmentRepository.getAppointmentByAppointmentId(appointmentId);
    }

    @PostMapping
    public void addAppointment(@RequestBody Appointment appointment) {
        appointmentRepository.addAppointment(appointment);
    }

    @DeleteMapping("/{appointmentId}")
    public void addAppointment(@PathVariable Long appointmentId) {
        appointmentRepository.addAppointment(appointmentId);
    }

}
