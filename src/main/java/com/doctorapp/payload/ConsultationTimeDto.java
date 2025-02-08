package com.doctorapp.payload;

import com.doctorapp.entity.Doctor;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class ConsultationTimeDto {
    private Long id;

    private LocalDate date;

    private String time;

    private String status;

    private Doctor doctor;
}
