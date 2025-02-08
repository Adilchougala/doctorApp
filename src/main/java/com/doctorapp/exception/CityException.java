package com.doctorapp.exception;

import com.doctorapp.entity.City;

public class CityException extends RuntimeException{
    public CityException(String message){
        super(message);
    }
}
