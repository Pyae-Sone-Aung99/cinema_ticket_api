package com.example.cinematicketapi.model.repo;

import com.example.cinematicketapi.model.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ScheduleRepo extends JpaRepository<Schedule,Integer> {

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Schedule s where s.nowShowingMovies.id = :id")
    void deleteScheduleByNowShowingMoviesId(int id);
}
