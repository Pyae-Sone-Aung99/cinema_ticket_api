package com.example.cinematicketapi.model.repo;

import com.example.cinematicketapi.model.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleRepo extends JpaRepository<Schedule,Integer> {

    @Query(value = "select DISTINCT sch from Schedule sch where sch.nowShowingMovies.id = :id")
    List<Schedule> findByNowShowingMoviesId(int id);
}
