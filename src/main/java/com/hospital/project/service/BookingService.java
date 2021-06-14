package com.hospital.project.service;

import com.hospital.project.models.Booking;
import com.hospital.project.models.ERole;
import com.hospital.project.models.User;
import com.hospital.project.repository.BookingRepository;
import com.hospital.project.repository.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private UserRepository userRepository;

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public void saveBooking(Booking booking) {
        String bookingId = "BOOK" + RandomStringUtils.randomAlphanumeric(6).toUpperCase();
        booking.setBookingId(bookingId);
        booking.setAppointmentDate(new Date(booking.getAppointmentTime().getTime()));
        bookingRepository.save(booking);
    }

    public List<Booking> findAllByEmail(String email) {
        if (!email.isEmpty()) {
            User user = userRepository.findOneByEmail(email);
            if (ERole.ROLE_ADMIN.equals(user.getRole())) {
                return bookingRepository.findAll();
            } else if (ERole.ROLE_TECHNICIAN.equals(user.getRole())) {
                return bookingRepository.findAllByAppointmentDate(new Date());
            } else {
                return bookingRepository.findAllByEmail(email);
            }
        }
        return bookingRepository.findAll();
    }

    public List<Booking> searchByDate(Date date) {
        return bookingRepository.findAllByAppointmentDate(date);
    }

    public List<Booking> searchByTestType(String testName) {
        return bookingRepository.findAllByTypeContaining(testName);
    }
}
