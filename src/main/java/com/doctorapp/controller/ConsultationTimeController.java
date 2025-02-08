package com.doctorapp.controller;

import com.doctorapp.payload.ConsultationTimeDto;
import com.doctorapp.service.ConsultationTimeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/consultationTime")
@Tag(name="Consultation Time APIs", description = "write")
public class ConsultationTimeController {
    private ConsultationTimeService consultationTimeService;

    public ConsultationTimeController(ConsultationTimeService consultationTimeService) {
        this.consultationTimeService = consultationTimeService;
    }

    @PostMapping("/add/consultationTime")
    public ResponseEntity<ConsultationTimeDto> addConsultationTime(@RequestBody ConsultationTimeDto consultationTimeDto,
                                                                   @RequestParam long doctorId){
        ConsultationTimeDto dto = consultationTimeService.addConsultationTime(consultationTimeDto, doctorId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}


