package com.example.demosqldocker.entities;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class ErrorDetails {
    private Date timestamp;
    private String message;
    private String details;

}
