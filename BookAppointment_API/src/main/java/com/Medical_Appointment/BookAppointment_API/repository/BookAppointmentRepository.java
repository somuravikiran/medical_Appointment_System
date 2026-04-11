package com.Medical_Appointment.BookAppointment_API.repository;

import com.Medical_Appointment.BookAppointment_API.entity.BookAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface BookAppointmentRepository extends JpaRepository<BookAppointment,Long> {

    boolean existsByDoctorIdAndAppointmentDateAndAppointmentTime(
            Long doctorId,
            LocalDate appointmentDate,
            LocalTime appointmentTime
    );
}
