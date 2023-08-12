package com.gersgarage.controllers;


import com.gersgarage.dto.BookingDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class BookingController {

/*
    private final BookingService bookingService;
*/

    /*@Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }*/

    @PostMapping("/booking")
    public ResponseEntity<String> updateBookingType(@RequestBody BookingDTO bookingDTO) {
        /*boolean updated = bookingService.updateBookingType(bookingDTO.getType());

        if (updated) {
            return ResponseEntity.ok("Booking type updated successfully.");
        } else {
            return ResponseEntity.badRequest().body("Booking not found or update failed.");
        }*/

        return ResponseEntity.ok("Booking type updated successfully.");
    }
}








