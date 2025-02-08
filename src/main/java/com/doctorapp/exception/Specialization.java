package com.doctorapp.exception;

import com.doctorapp.payload.ErrorHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Specialization {

    @ExceptionHandler(SpecializationException.class)
    public ResponseEntity<ErrorHandler> specializationNotFound(SpecializationException ex) {
        ErrorHandler errorResponse = new ErrorHandler(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CityException.class)
    public ResponseEntity<ErrorHandler> CityNotFound(CityException ex) {
        ErrorHandler errorResponse = new ErrorHandler(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AreaException.class)
    public ResponseEntity<ErrorHandler> areaNotFoundException(AreaException ex) {
        ErrorHandler errorResponse = new ErrorHandler(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DoctorException.class)
    public ResponseEntity<ErrorHandler> doctorNotFound(DoctorException ex) {
        ErrorHandler errorResponse = new ErrorHandler(HttpStatus.NOT_FOUND.value(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
