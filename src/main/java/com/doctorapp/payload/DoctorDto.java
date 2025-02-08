package com.doctorapp.payload;

import com.doctorapp.entity.Area;
import com.doctorapp.entity.City;
import com.doctorapp.entity.Specialization;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDto {
    private Long id;

    private String name;

    private Byte experience;

    private String profile;

    private Specialization specialization;

    private City city;

    private Area area;
}
