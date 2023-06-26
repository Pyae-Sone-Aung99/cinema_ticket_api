package com.example.cinematicketapi.model.repo;

import com.example.cinematicketapi.model.dto.StaffDto;
import com.example.cinematicketapi.model.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffRepo extends JpaRepository<Staff,Integer> {

    @Query(value = "select DISTINCT s from Staff s where s.cinema.id = :id")
    List<StaffDto> findByCinemaId(int id);
}
