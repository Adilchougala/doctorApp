package com.doctorapp.service;

import com.doctorapp.entity.Booking;
import com.doctorapp.entity.ConsultationTime;
import com.doctorapp.entity.Doctor;
import com.doctorapp.entity.Patient;
import com.doctorapp.exception.DoctorException;
import com.doctorapp.exception.SpecializationException;
import com.doctorapp.mapper.BookingMapper;
import com.doctorapp.payload.BookingDto;
import com.doctorapp.repository.BookingRepository;
import com.doctorapp.repository.ConsultationTimeRepository;
import com.doctorapp.repository.DoctorRepository;
import com.doctorapp.repository.PatientRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class BookingService {

    private BookingRepository bookingRepository;
    private ConsultationTimeRepository consultationTimeRepository;
    private DoctorRepository doctorRepository;
    private PatientRepository patientRepository;
    private BookingMapper bookingMapper;

    public BookingDto createBooking(BookingDto bookingDto, long doctorId, long patientId) {
        try {
            Doctor doctor = doctorRepository.findById(doctorId).orElseThrow(() -> new DoctorException("no doctor find with this id"));
            Patient patient = patientRepository.findById(patientId).orElseThrow(() -> new DoctorException("new Patient found with this id"));
            ConsultationTime consultationTime = consultationTimeRepository.checkDoctorAvailability(doctorId, bookingDto.getDate(), bookingDto.getTime()).orElseThrow(() -> new SpecializationException("Sorry, this slot is already booked. Please choose another slot."));
            bookingDto.setDoctor(doctor);
            bookingDto.setPatient(patient);
            Booking booking = bookingMapper.dtoToEntity(bookingDto);
            Booking savedBooking = bookingRepository.save(booking);
            BookingDto bookingDto1 = bookingMapper.entityToDto(savedBooking);
            consultationTime.setStatus("BOOKED");
            consultationTimeRepository.save(consultationTime);
            return bookingDto1;
        } catch (DoctorException e) {
            log.error("Exception while saving the booking: {}, {}", bookingDto.getClass(), e);
            throw e;
        } catch(Exception e ){
            log.error("Exception ehile saving the booking: {}, {}", bookingDto.getClass(), e);
            throw new RuntimeException("Excetion while saving the bookign"+bookingDto);
        }
    }

    public void cancelBooking(long bookingId) {
        try {
            Booking booking = bookingRepository.findById(bookingId).orElseThrow(() -> new SpecializationException("Sorry no booking id is found with this id"));
            ConsultationTime consultationTime = consultationTimeRepository
                    .findByDoctorIdAndDateAndTime(booking.getDoctor().getId(), booking.getDate(), booking.getTime())
                    .orElseThrow(() -> new SpecializationException("No consultation time found for this booking. "));
            consultationTime.setStatus("AVAILABLE");
            consultationTimeRepository.save(consultationTime);
            bookingRepository.deleteById(bookingId);
        } catch (DoctorException e) {
            log.error("Exception while cancelling the appointment: {}", e);
            throw e;
        }
    }
}
