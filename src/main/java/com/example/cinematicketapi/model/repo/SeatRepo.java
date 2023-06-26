package com.example.cinematicketapi.model.repo;

import com.example.cinematicketapi.model.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepo extends JpaRepository<Seat,Integer> {
}
