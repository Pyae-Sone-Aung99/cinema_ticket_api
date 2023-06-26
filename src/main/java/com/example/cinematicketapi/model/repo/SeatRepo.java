package com.example.cinematicketapi.model.repo;

import com.example.cinematicketapi.model.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SeatRepo extends JpaRepository<Seat,Integer> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Seat st where st.theater.id = :id")
    void deleteSeatByTheaterId(int id);
}
