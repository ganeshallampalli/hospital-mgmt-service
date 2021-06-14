package com.hospital.project.controllers;

import com.hospital.project.models.Booking;
import com.hospital.project.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @PostMapping
    public void saveBooking(@RequestBody Booking booking) {
        bookingService.saveBooking(booking);
    }

    @GetMapping("/all")
    public List<Booking> getBookingByEmail(@RequestParam String email) {
        return bookingService.findAllByEmail(email);
    }

    @GetMapping("/search/date")
    public List<Booking> searchByDate(@RequestParam String date) throws ParseException {
        if (date.isEmpty()) {
            return bookingService.findAllByEmail(new String());
        }
        Date searchDate = sdf.parse(date);
        return bookingService.searchByDate(searchDate);
    }

    @GetMapping("/search/test")
    public List<Booking> searchByTestType(@RequestParam String testName) {
        if (testName.isEmpty()) {
            return bookingService.findAllByEmail(new String());
        }
        return bookingService.searchByTestType(testName);
    }
}
