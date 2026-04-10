package com.Medical_Appointment.DoctorAvailability_API.repository;

import com.Medical_Appointment.DoctorAvailability_API.entity.DoctorAvailability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorAvailabilityRepository extends JpaRepository<DoctorAvailability,Long> {
}
