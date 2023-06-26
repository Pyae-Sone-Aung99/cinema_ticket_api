package com.example.cinematicketapi.model.repo;

import com.example.cinematicketapi.model.dto.TheaterDto;
import com.example.cinematicketapi.model.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TheaterRepo extends JpaRepository<Theater,Integer> {

    @Query(value = "select DISTINCT t from Theater t where t.cinema.id = :id")
    List<TheaterDto> findByCinemaId(int id);
}
