package com.doctorapp.mapper;

import com.doctorapp.entity.Doctor;
import com.doctorapp.payload.DoctorDto;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface DoctorMapper {

    Doctor dtoToEntity(DoctorDto doctorDto);

    DoctorDto entityToDto(Doctor doctor);
}
