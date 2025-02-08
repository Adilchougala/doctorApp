package com.doctorapp.mapper;

import com.doctorapp.entity.Area;
import com.doctorapp.payload.AreaDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AreaMapper {

    Area dtoToEntity(AreaDto areaDto);

    AreaDto entityToDto(Area area);
}
