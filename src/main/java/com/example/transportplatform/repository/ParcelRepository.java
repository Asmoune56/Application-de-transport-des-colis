package com.example.transportplatform.repository;


import com.example.transportplatform.model.Parcel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<Parcel, Long> {
}

