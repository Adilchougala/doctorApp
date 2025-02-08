package com.doctorapp.controller;

import com.doctorapp.payload.CityDto;
import com.doctorapp.service.CityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/city")
@Tag(name="City APIs", description = "write")
public class CityController {
    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping("/saveCity")
    public ResponseEntity<CityDto> addCity(@RequestBody CityDto cityDto){
        CityDto cityDto1 = cityService.addCity(cityDto);
        return new ResponseEntity<>(cityDto1, HttpStatus.OK);
    }
}
