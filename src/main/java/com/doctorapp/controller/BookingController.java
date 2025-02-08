package com.doctorapp.controller;

import com.doctorapp.payload.BookingDto;
import com.doctorapp.service.BookingService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/bookings")
@Tag(name="Booking APIs", description = "Write, Delete")
public class BookingController {
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/addBooking")
    @Operation(summary = "create the appointment with the doctor")
    public ResponseEntity<BookingDto> createBooking(@RequestBody BookingDto bookingDto,
                                                    @RequestParam long doctorId,
                                                    @RequestParam long patientId){
        BookingDto booking = bookingService.createBooking(bookingDto, doctorId, patientId);
        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @DeleteMapping("/cancelBooking")
    @Operation(summary = "cancel the appointment")
    public ResponseEntity<String> cancelBooking(@RequestParam long bookingId){
        bookingService.cancelBooking(bookingId);
        return new ResponseEntity<>("Your booking has been canceled",HttpStatus.OK);
    }
}
