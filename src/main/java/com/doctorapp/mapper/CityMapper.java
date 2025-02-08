package com.doctorapp.mapper;

import com.doctorapp.entity.City;
import com.doctorapp.payload.CityDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City dtoToEntity(CityDto cityDto);

    CityDto entityToDto(City city);
}
