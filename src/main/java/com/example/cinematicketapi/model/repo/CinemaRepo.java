package com.example.cinematicketapi.model.repo;

import com.example.cinematicketapi.model.dto.CinemaDto;
import com.example.cinematicketapi.model.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CinemaRepo extends JpaRepository<Cinema,Integer> {

    @Query(value = "select DISTINCT c from Cinema c where c.company.id = :id")
    List<CinemaDto> findByCompanyId(int id);
}
