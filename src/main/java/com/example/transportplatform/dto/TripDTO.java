package com.example.transportplatform.dto;


import lombok.Data;

@Data
public class TripDTO {
    private Long id;
    private String departure;
    private String destination;
    private String stops;
    private String cargoType;
    private double maxDimensions;
    private double availableCapacity;
    private Long driverId;
}

