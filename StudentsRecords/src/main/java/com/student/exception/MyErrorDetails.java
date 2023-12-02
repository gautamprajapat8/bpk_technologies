package com.student.exception;

import java.time.LocalDateTime;

public class MyErrorDetails {

    private LocalDateTime timestamp;
    private String message;
    private String description;

    public MyErrorDetails() {
    }

    public MyErrorDetails(LocalDateTime timestamp, String message, String description) {
        this.timestamp = timestamp;
        this.message = message;
        this.description = description;
    }

    // Getters and setters

    @Override
    public String toString() {
        return "MyErrorDetails{" +
                "timestamp=" + timestamp +
                ", message='" + message + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
