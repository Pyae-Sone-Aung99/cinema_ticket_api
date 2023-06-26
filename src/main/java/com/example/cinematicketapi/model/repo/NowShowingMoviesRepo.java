package com.example.cinematicketapi.model.repo;

import com.example.cinematicketapi.model.dto.NowShowingMoviesDto;
import com.example.cinematicketapi.model.entity.NowShowingMovies;
import com.example.cinematicketapi.model.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NowShowingMoviesRepo extends JpaRepository<NowShowingMovies,Integer> {

    @Query(value = "select DISTINCT nsm from NowShowingMovies nsm where nsm.cinema.id = :id")
    List<NowShowingMoviesDto> findByCinemaId(int id);

}
