package com.example.cinematicketapi.model.repo;

import com.example.cinematicketapi.model.dto.UpComingMoviesDto;
import com.example.cinematicketapi.model.entity.UpComingMovies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UpComingMoviesRepo extends JpaRepository<UpComingMovies,Integer> {

    @Query(value = "select DISTINCT upc from UpComingMovies upc where upc.cinema.id = :id")
    List<UpComingMoviesDto> findByCinemaId(int id);
}
