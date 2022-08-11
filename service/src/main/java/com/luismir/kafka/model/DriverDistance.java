package com.luismir.kafka.model;

import lombok.Data;

@Data
public class DriverDistance {

    private String email;

    private double latitude;

    private double longitude;

    private double distanceFromStore;
}
