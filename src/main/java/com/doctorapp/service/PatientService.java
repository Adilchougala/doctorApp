package com.doctorapp.service;

import com.doctorapp.entity.Patient;
import com.doctorapp.payload.PatientDto;
import com.doctorapp.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class PatientService {

    private PatientRepository patientRepository;


    public PatientDto createPatient(PatientDto patientDto) {
        try {
            Patient patient = new Patient();
            patient.setName(patientDto.getName());
            patient.setMobile(patientDto.getMobile());
            patient.setEmailId(patientDto.getEmailId());
            patient.setPassword(patientDto.getPassword());
            patient.setRole(patientDto.getRole());
            Patient savedPatient = patientRepository.save(patient);
            patientDto.setId(savedPatient.getId());
            patientDto.setName(savedPatient.getName());
            patientDto.setMobile(savedPatient.getMobile());
            patientDto.setEmailId(savedPatient.getEmailId());
            patientDto.setPassword(savedPatient.getPassword());
            patientDto.setRole(savedPatient.getRole());
            return patientDto;
        }catch (RuntimeException e){
            log.error("exception while saving the patient{}",patientDto);
            throw new RuntimeException("Exception while saving the patient"+e);
        }
    }
}
