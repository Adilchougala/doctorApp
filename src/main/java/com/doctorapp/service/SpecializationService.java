package com.doctorapp.service;

import com.doctorapp.entity.Specialization;
import com.doctorapp.exception.SpecializationException;
import com.doctorapp.payload.SpecializationDto;
import com.doctorapp.repository.SpecializationRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class SpecializationService {
    private SpecializationRepository specializationRepository;

    //Adding the Specialization
    public SpecializationDto addSpecialization(SpecializationDto specializationDto) {
        try {
            Specialization entity = new Specialization();
            entity.setExpertise(specializationDto.getExpertise());
            Specialization savedSpecialization = specializationRepository.save(entity);
            specializationDto.setId(savedSpecialization.getId());
            specializationDto.setExpertise(savedSpecialization.getExpertise());
            return specializationDto;
        } catch (SpecializationException e) {
            log.error("Exception while adding the specialization: {}", e, specializationDto);
            throw new SpecializationException("Exception while adding the specialization" + e);
        }
    }
}
