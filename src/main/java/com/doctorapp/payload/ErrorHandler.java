package com.doctorapp.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorHandler {
    private int status;
    private String message;
    private long timestamp;

    public ErrorHandler(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }
}
