package com.doctorapp.mapper;

import com.doctorapp.entity.Patient;
import com.doctorapp.payload.PatientDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient dtoToEntity(PatientDto patientDto);

    PatientDto entityToDto(Patient patient);
}
