package com.Medical_Appointment.DoctorAvailability_API.service;

import com.Medical_Appointment.DoctorAvailability_API.dto.DoctorAvailabilityRequest;
import com.Medical_Appointment.DoctorAvailability_API.dto.DoctorAvailabilityResponse;
import com.Medical_Appointment.DoctorAvailability_API.entity.DoctorAvailability;
import com.Medical_Appointment.DoctorAvailability_API.repository.DoctorAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorAvailabilityService {

    @Autowired
    private DoctorAvailabilityRepository repo;

    public DoctorAvailabilityResponse addAvailability(DoctorAvailabilityRequest request){
        if (request.getStartTime().isAfter(request.getEndTime())){
            throw new RuntimeException("Start Time Should be End Time!!");
        }

        DoctorAvailability entity = new DoctorAvailability();
        entity.setDoctorId(request.getDoctorId());
        entity.setDate(request.getDate());
        entity.setStartTime(request.getStartTime());
        entity.setEndTime(request.getEndTime());

        DoctorAvailability saved = repo.save(entity);
        return DoctorAvailabilityResponse.builder()
                .id(entity.getId())
                .doctorId(entity.getDoctorId())
                .date(entity.getDate())
                .startTime(entity.getStartTime())
                .endTime(entity.getEndTime())
                .build();
    }
}
