package com.doctorapp.repository;

import com.doctorapp.entity.ConsultationTime;
import com.doctorapp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface ConsultationTimeRepository extends JpaRepository<ConsultationTime, Long> {
    List<ConsultationTime> findByDoctorAndStatus(Doctor doctor, String status);

    @Query("SELECT ct FROM ConsultationTime ct WHERE ct.doctor.id = :doctorId AND ct.date = :date AND ct.time = :time AND ct.status = 'AVAILABLE'")
    Optional<ConsultationTime> checkDoctorAvailability(@Param("doctorId") Long doctorId, @Param("date") LocalDate date, @Param("time") String time);

    @Query("SELECT ct FROM ConsultationTime ct WHERE ct.doctor.id = :doctorId AND ct.date = :date AND ct.time = :time")
    Optional<ConsultationTime> findByDoctorIdAndDateAndTime(@Param("doctorId") Long doctorId,
                                                            @Param("date") LocalDate date,
                                                            @Param("time") String time);

}