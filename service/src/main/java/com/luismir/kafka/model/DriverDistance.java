package com.luismir.kafka.model;

import lombok.Data;

@Data
public class DriverDistance {

    private String driverID;

    private double distance;

    public DriverDistance(String driverID, double distance) {
        this.driverID = driverID;
        this.distance = distance;
    }
}
