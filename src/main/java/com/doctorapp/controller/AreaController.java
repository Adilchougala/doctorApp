package com.doctorapp.controller;

import com.doctorapp.payload.AreaDto;
import com.doctorapp.service.AreaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/areas")
@AllArgsConstructor
@Tag(name="Area APIs", description = "write")
public class AreaController {


    private AreaService areaService;

    @PostMapping("/saveArea")
    @Operation(summary = "Add the area")
    public ResponseEntity<AreaDto> addArea(@RequestBody AreaDto areaDto) {
        AreaDto areaDto1 = areaService.addArea(areaDto);
        return new ResponseEntity<>(areaDto1, HttpStatus.OK);
    }
}
