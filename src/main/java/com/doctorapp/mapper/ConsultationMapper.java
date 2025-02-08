package com.doctorapp.mapper;

import com.doctorapp.entity.ConsultationTime;
import com.doctorapp.payload.ConsultationTimeDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConsultationMapper {

    ConsultationTime dtoToEntity(ConsultationTimeDto consultationTimeDto);

    ConsultationTimeDto entityToDto(ConsultationTime consultationTime);
}
