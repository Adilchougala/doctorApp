package com.doctorapp.service;

import com.doctorapp.entity.*;
import com.doctorapp.exception.CityException;
import com.doctorapp.exception.DoctorException;
import com.doctorapp.mapper.ConsultationMapper;
import com.doctorapp.mapper.DoctorMapper;
import com.doctorapp.mapper.SpecializationMapper;
import com.doctorapp.payload.ConsultationTimeDto;
import com.doctorapp.exception.SpecializationException;
import com.doctorapp.payload.DoctorDto;
import com.doctorapp.repository.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
@Slf4j
public class DoctorService {
    private DoctorRepository doctorRepository;
    private SpecializationRepository specializationRepository;
    private CityRepository cityRepository;
    private AreaRepository areaRepository;
    private ConsultationTimeRepository consultationTimeRepository;
    private DoctorMapper doctorMapper;
    private ConsultationMapper consultationMapper;

    public DoctorDto addDoctor(DoctorDto doctorDto, long specializationId, long cityId, long areaId) {
        try {
            Specialization specialization = specializationRepository.findById(specializationId).orElseThrow(() -> new SpecializationException("Could not find specialization"));
            City city = cityRepository.findById(cityId).orElseThrow(() -> new CityException("Could not find city"));
            Area area = areaRepository.findById(areaId).orElseThrow(() -> new CityException("Could not find area"));
            Doctor doctor = doctorMapper.dtoToEntity(doctorDto);
            doctor.setSpecialization(specialization);
            doctor.setCity(city);
            doctor.setArea(area);
            Doctor savedDoctor = doctorRepository.save(doctor);
            DoctorDto doctorDto1 = doctorMapper.entityToDto(savedDoctor);
            return doctorDto1;
        } catch (DoctorException e) {
            log.error("Exception while adding the doctor: {}", doctorDto, e);
            throw new DoctorException("Exception while adding the doctor: " + e);
        }
    }

    public List<DoctorDto> findDoctorBySpecializationAndCitOrAreaName(String specialization, String cityName) {
        try {
            List<Doctor> doctor = doctorRepository.findDoctorBySpecialistAndCityOrArea(specialization, cityName);
            if (doctor.isEmpty()) {
                throw new SpecializationException("could not find any record based on your search ");
            }
            List<DoctorDto> doctors = doctor.stream().map(doctorMapper::entityToDto).collect(Collectors.toList());
            return doctors;
        } catch (SpecializationException e) {
            log.error("Exception while finding the doctor: {}", e, specialization, cityName);
            throw new SpecializationException("Exception while finding the doctor" + e);
        }
    }

    DoctorDto entityToDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setName(doctor.getName());
        doctorDto.setExperience(doctor.getExperience());
        doctorDto.setProfile(doctor.getProfile());
        doctorDto.setSpecialization(doctor.getSpecialization());
        doctorDto.setCity(doctor.getCity());
        doctorDto.setArea(doctor.getArea());
        return doctorDto;
    }

    public List<ConsultationTimeDto> findByDoctorAndStatus(Doctor doctor, String status) {
        try {
            List<ConsultationTime> availability = consultationTimeRepository.findByDoctorAndStatus(doctor, status);
            List<ConsultationTimeDto> dtoList = new ArrayList<>();
            if (availability.isEmpty()) {
                throw new SpecializationException("No doctor is found for the given doctor and status");
            }
            //List<ConsultationTimeDto> collect = availability.stream().map(p->entityToDto1(p)).collect(Collectors.toList());
            List<ConsultationTimeDto> collect = availability.stream().map(consultationMapper::entityToDto).collect(Collectors.toList());
            return collect;

        } catch (SpecializationException e) {
            log.error("Exception while finding the available doctor: {}", doctor, status, e);
            throw new SpecializationException("Exception while finding the available doctor" + e);
        }
    }

    ConsultationTimeDto entityToDto1(ConsultationTime consultationTime) {
        ConsultationTimeDto dto = new ConsultationTimeDto();
        dto.setId(consultationTime.getId());
        dto.setTime(consultationTime.getTime());
        dto.setDate(consultationTime.getDate());
        dto.setStatus(consultationTime.getStatus());
        dto.setDoctor(consultationTime.getDoctor());
        return dto;
    }
}


