package com.doctorapp.payload;

import com.doctorapp.entity.Doctor;
import com.doctorapp.entity.Patient;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class BookingDto {
    private Long id;

    private LocalDate date;

    private String time;


    private Patient patient;


    private Doctor doctor;
}
