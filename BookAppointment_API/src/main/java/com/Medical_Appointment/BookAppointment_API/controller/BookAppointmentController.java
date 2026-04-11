package com.Medical_Appointment.BookAppointment_API.controller;

import com.Medical_Appointment.BookAppointment_API.dto.BookAppointmentRequest;
import com.Medical_Appointment.BookAppointment_API.dto.BookAppointmentResponse;
import com.Medical_Appointment.BookAppointment_API.service.BookAppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookAppointmentController {

    @Autowired
    private BookAppointmentService service;

    @PostMapping("/BookAppointment")
    public ResponseEntity<BookAppointmentResponse> bookAppointment(
            @Valid @RequestBody BookAppointmentRequest request){
        return ResponseEntity.ok(service.bookAppointment(request));
    }
}
