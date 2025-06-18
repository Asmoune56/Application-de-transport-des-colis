package com.example.transportplatform.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter  @Setter
public class RequestDTO {
    private Long id;
    private LocalDate requestDate;
    private String status;
    private Long senderId;
    private Long tripId;
    private ParcelDTO parcel;
}

