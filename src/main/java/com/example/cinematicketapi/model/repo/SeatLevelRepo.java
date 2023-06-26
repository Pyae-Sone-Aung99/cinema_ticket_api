package com.example.cinematicketapi.model.repo;

import com.example.cinematicketapi.model.entity.SeatLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatLevelRepo extends JpaRepository<SeatLevel,Integer> {
}
