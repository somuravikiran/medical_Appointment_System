package com.Medical_Appointment.BookAppointment_API.service;

import com.Medical_Appointment.BookAppointment_API.dto.BookAppointmentRequest;
import com.Medical_Appointment.BookAppointment_API.dto.BookAppointmentResponse;
import com.Medical_Appointment.BookAppointment_API.entity.BookAppointment;
import com.Medical_Appointment.BookAppointment_API.entity.User;
import com.Medical_Appointment.BookAppointment_API.repository.BookAppointmentRepository;
import com.Medical_Appointment.BookAppointment_API.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookAppointmentService {

    @Autowired
    private BookAppointmentRepository repo;

    @Autowired
    private UserRepository userRepo;

    public BookAppointmentResponse bookAppointment(BookAppointmentRequest request){

        User patient =userRepo.findById(request.getPatientId())
                .orElseThrow(() -> new RuntimeException("Patient Not Found"));

        if(!"PATIENT".equals(patient.getRole())){
            throw new RuntimeException("Invalid Patient");
        }

        User doctor = userRepo.findById(request.getDoctorId())
                .orElseThrow(()->new RuntimeException("Doctor Not Found"));

        if(!"DOCTOR".equals(doctor.getRole())){
            throw new RuntimeException("Invalid Doctor");
        }

        Boolean exists = repo.existsByDoctorIdAndAppointmentDateAndAppointmentTime(
                request.getDoctorId(),
                request.getAppointmentDate(),
                request.getAppointmentTime()
        );
        if(exists){
            throw new RuntimeException("Slot already booked!!");
        }

        BookAppointment appointment = new BookAppointment();
        appointment.setDoctorId(request.getDoctorId());
        appointment.setPatientId(request.getPatientId());
        appointment.setAppointmentDate(request.getAppointmentDate());
        appointment.setAppointmentTime(request.getAppointmentTime());
        appointment.setReason(request.getReason());
        appointment.setStatus("Booked");

        BookAppointment saved = repo.save(appointment);

        BookAppointmentResponse response = new BookAppointmentResponse();
        response.setAppointmentId(saved.getId());
        response.setDoctorId(saved.getDoctorId());
        response.setPatientId(saved.getPatientId());
        response.setAppointmentDate(saved.getAppointmentDate());
        response.setAppointmentTime(saved.getAppointmentTime());
        response.setStatus(saved.getStatus());
        response.setMessage("Appointment booked Successful!");
        return response;
    }
}
