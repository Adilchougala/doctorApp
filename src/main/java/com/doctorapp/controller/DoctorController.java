package com.doctorapp.controller;

import com.doctorapp.entity.Doctor;
import com.doctorapp.payload.ConsultationTimeDto;
import com.doctorapp.payload.DoctorDto;
import com.doctorapp.service.DoctorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
@Tag(name="Doctor APIs", description = "write, Read, Read")
public class DoctorController {
    private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    //Add Doctor Information
    @PostMapping("/addDoctor")
    @Operation(summary = "Register new doctor")
    public ResponseEntity<DoctorDto> addDoctor(@RequestBody DoctorDto doctorDto,
                                               @RequestParam long specializationId,
                                               @RequestParam long cityId,
                                               @RequestParam long areaId) {
        DoctorDto doctorDto1 = doctorService.addDoctor(doctorDto, specializationId, cityId, areaId);
        return new ResponseEntity<>(doctorDto1, HttpStatus.OK);
    }

    //Search doctor based on speacialization and city or area name
    @GetMapping("/search/doctor/With/SpecializationAndCityOrAreaName")
    @Operation(summary = "find the doctor based on specialization and city or Area name")
    public ResponseEntity<List<DoctorDto>> findDoctorBySpecializationAndCitOrAreaName(@RequestParam String specialization,
                                                                                      @RequestParam String cityName) {
        List<DoctorDto> doctorBySpecializationAndCitOrAreaName = doctorService.findDoctorBySpecializationAndCitOrAreaName(specialization, cityName);
        return new ResponseEntity<>(doctorBySpecializationAndCitOrAreaName, HttpStatus.OK);
    }

    //get doctor details who is available
    @GetMapping("/availability")
    @Operation(summary = "check doctor availability")
    public ResponseEntity<List<ConsultationTimeDto>> findByDoctorAndStatus(@RequestParam Doctor doctor, @RequestParam String status){
        List<ConsultationTimeDto> byDoctorAndStatus = doctorService.findByDoctorAndStatus(doctor, status);
        return new ResponseEntity<>(byDoctorAndStatus,HttpStatus.OK);
    }
}


