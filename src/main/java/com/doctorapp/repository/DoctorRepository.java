package com.doctorapp.repository;

import com.doctorapp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

   // @Query("select d from Doctor d JOIN d.specialization s JOIN d.city c JOIN d.area WHERE s.expertise=:expertise AND c.name=:cityName OR a.name=:areaName")
   //List<Doctor> findDoctorBySpecialistAndCityOrArea(@Param("expertise") String expertise, @Param("cityName") String cityName, @Param("areaName") String areaName);

    @Query("SELECT d FROM Doctor d " +
            "JOIN d.specialization s " +
            "JOIN d.city c " +
            "JOIN d.area a " +
            "WHERE s.expertise = :expertise " +
            "AND (c.name = :cityName OR a.name = :cityName)")
    List<Doctor> findDoctorBySpecialistAndCityOrArea(@Param("expertise") String expertise,
                                                     @Param("cityName") String cityName);

}