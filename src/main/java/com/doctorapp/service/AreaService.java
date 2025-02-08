package com.doctorapp.service;

import com.doctorapp.entity.Area;
import com.doctorapp.exception.AreaException;
import com.doctorapp.mapper.AreaMapper;
import com.doctorapp.payload.AreaDto;
import com.doctorapp.repository.AreaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class AreaService {
    private AreaRepository areaRepository;
    private AreaMapper areaMapper;


    public AreaDto addArea(AreaDto areaDto) {
        try {
            Area area = areaMapper.dtoToEntity(areaDto);
            Area savedArea = areaRepository.save(area);
            AreaDto areaDto1 = areaMapper.entityToDto(savedArea);
            return areaDto1;
        } catch (AreaException e) {
            log.error("Exception while saving the area : {}", e);
            throw e;
        } catch (Exception e) {
            log.error("Exception while saving the area :{}", e);
            throw new RuntimeException("Exception while saving the area : " + e);
        }
    }
}
