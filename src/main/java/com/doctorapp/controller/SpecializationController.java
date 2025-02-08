package com.doctorapp.controller;

import com.doctorapp.payload.SpecializationDto;
import com.doctorapp.service.SpecializationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/specializations")
@Tag(name="Specialization APIs", description = "write")
public class SpecializationController {
    private SpecializationService specializationService;

    public SpecializationController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @PostMapping("/saveSpecialization")
    public ResponseEntity<SpecializationDto> addSpecialization(@RequestBody SpecializationDto specializationDto){
        SpecializationDto specializationDto1 = specializationService.addSpecialization(specializationDto);
        return new ResponseEntity<>(specializationDto, HttpStatus.OK);
    }
}
