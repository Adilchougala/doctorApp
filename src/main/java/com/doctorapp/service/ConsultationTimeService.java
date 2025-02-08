package com.doctorapp.service;

import com.doctorapp.entity.ConsultationTime;
import com.doctorapp.entity.Doctor;
import com.doctorapp.exception.DoctorException;
import com.doctorapp.payload.ConsultationTimeDto;
import com.doctorapp.repository.ConsultationTimeRepository;
import com.doctorapp.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ConsultationTimeService {
    private ConsultationTimeRepository consultationTimeRepository;
    private DoctorRepository doctorRepository;


    public ConsultationTimeDto addConsultationTime(ConsultationTimeDto consultationTimeDto, long doctorId) {
        try {
            Doctor doctor = doctorRepository.findById(doctorId)
                    .orElseThrow(() -> new DoctorException("There is not doctor present with this id: " + doctorId));
            ConsultationTime entity = new ConsultationTime();
            entity.setDate(consultationTimeDto.getDate());
            entity.setTime(consultationTimeDto.getTime());
            entity.setStatus(consultationTimeDto.getStatus());
            entity.setDoctor(doctor);
            ConsultationTime save = consultationTimeRepository.save(entity);
            consultationTimeDto.setId(save.getId());
            consultationTimeDto.setDate(save.getDate());
            consultationTimeDto.setTime(save.getTime());
            consultationTimeDto.setStatus(save.getStatus());
            consultationTimeDto.setDoctor(save.getDoctor());
            return consultationTimeDto;
        } catch (RuntimeException e) {
            log.error("Exception while adding the timing: {}" + e);
            throw new RuntimeException("Exception while adding the timing " + e);
        }
    }
}
