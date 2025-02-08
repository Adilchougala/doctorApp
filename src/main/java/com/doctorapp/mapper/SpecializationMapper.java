package com.doctorapp.mapper;

import com.doctorapp.entity.Specialization;
import com.doctorapp.payload.SpecializationDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SpecializationMapper {

    Specialization dtoToEntity(SpecializationDto specializationDto);

    SpecializationDto entityToDto(Specialization specialization);
}
