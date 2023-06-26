package com.example.cinematicketapi.model.repo;

import com.example.cinematicketapi.model.entity.SeatLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SeatLevelRepo extends JpaRepository<SeatLevel,Integer> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM SeatLevel sl where sl.theater.id = :id")
    void deleteSeatLevelByTheaterId(int id);
}
