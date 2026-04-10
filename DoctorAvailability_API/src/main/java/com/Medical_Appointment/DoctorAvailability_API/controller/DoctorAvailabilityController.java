package com.Medical_Appointment.DoctorAvailability_API.controller;

import com.Medical_Appointment.DoctorAvailability_API.dto.DoctorAvailabilityRequest;
import com.Medical_Appointment.DoctorAvailability_API.dto.DoctorAvailabilityResponse;
import com.Medical_Appointment.DoctorAvailability_API.service.DoctorAvailabilityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DoctorAvailabilityController {

    @Autowired
    private DoctorAvailabilityService service;

    @PostMapping("/availability")
    public ResponseEntity<DoctorAvailabilityResponse> addAvailability(
            @Valid @RequestBody DoctorAvailabilityRequest request){
        return ResponseEntity.ok(service.addAvailability(request));
    }
}
