package com.example.cinematicketapi.model.repo;

import com.example.cinematicketapi.model.dto.SellingSeatLevelDto;
import com.example.cinematicketapi.model.entity.SeatLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SeatLevelRepo extends JpaRepository<SeatLevel,Integer> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM SeatLevel sl where sl.theater.id = :id")
    void deleteSeatLevelByTheaterId(int id);

//    @Query(value = " select new com.example.cinematicketapi.model.dto.SellingSeatLevelDto(sl.id, sl.level, sl.quantity, sl.price) FROM SeatLevel sl join Theater t on sl.theater.id = t.id where t.id = :theaterID")
//    List<SellingSeatLevelDto> findSeatLevelsByTheaterId(int theaterId);
}
