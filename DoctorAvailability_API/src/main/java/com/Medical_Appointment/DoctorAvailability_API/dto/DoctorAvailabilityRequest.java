package com.Medical_Appointment.DoctorAvailability_API.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorAvailabilityRequest {

    @NotBlank(message = "DoctorId should be not be blank")
    private String doctorId;

    @NotNull(message = "StartTime should not be null")
    private LocalDate date;

    @NotNull(message = "StartTime should not be null")
    private LocalTime startTime;

    @NotNull(message = "EndTime should not be null")
    private LocalTime endTime;
}
