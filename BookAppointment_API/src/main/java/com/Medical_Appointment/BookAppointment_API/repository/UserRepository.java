package com.Medical_Appointment.BookAppointment_API.repository;

import com.Medical_Appointment.BookAppointment_API.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
