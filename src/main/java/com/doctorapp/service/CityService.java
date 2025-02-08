package com.doctorapp.service;

import com.doctorapp.entity.City;
import com.doctorapp.exception.CityException;
import com.doctorapp.payload.CityDto;
import com.doctorapp.repository.CityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class CityService {
    private CityRepository cityRepository;


    public CityDto addCity(CityDto cityDto) {
        try {
            City city = new City();
            city.setName(cityDto.getName());
            City savedCity = cityRepository.save(city);
            cityDto.setId(savedCity.getId());
            cityDto.setName(savedCity.getName());
            return cityDto;
        } catch (CityException e) {
            log.error("Exception while adding the city: {}", e);
            throw new CityException("Exception while adding the city: " + cityDto);
        }
    }
}
