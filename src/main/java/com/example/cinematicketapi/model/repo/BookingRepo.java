package com.example.cinematicketapi.model.repo;

import com.example.cinematicketapi.model.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,Integer> {
}
