package com.example.cinematicketapi.model.repo;

import com.example.cinematicketapi.model.dto.SeatDto;
import com.example.cinematicketapi.model.dto.SellingSeatDto;
import com.example.cinematicketapi.model.dto.TheaterDto;
import com.example.cinematicketapi.model.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SeatRepo extends JpaRepository<Seat,Integer> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Seat st where st.theater.id = :id")
    void deleteSeatByTheaterId(int id);

    @Query(value = "select se from Seat se where se.theater.id = :id")
    List<SeatDto> findByTheaterId(int id);

//    @Query(value = "select new com.example.cinematicketapi.model.dto.SellingSeatDto(s.seatName,s.available) from Seat s join SeatLevel sl on s.level.id = sl.id where sl.id = :id")
//    List<SellingSeatDto> findSeatsById(int id);

}
