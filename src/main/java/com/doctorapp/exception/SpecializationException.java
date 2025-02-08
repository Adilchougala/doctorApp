package com.doctorapp.exception;

import com.doctorapp.entity.Specialization;

public class SpecializationException extends RuntimeException{
   public SpecializationException(String message){
        super(message);
    }
}
