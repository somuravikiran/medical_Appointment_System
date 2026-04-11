package com.Medical_Appointment.BookAppointment_API.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookAppointmentResponse {

    private Long appointmentId;

    private Long patientId;
    private Long doctorId;

    private LocalDate appointmentDate;
    private LocalTime appointmentTime;

    private String message;
    private String status;
}
