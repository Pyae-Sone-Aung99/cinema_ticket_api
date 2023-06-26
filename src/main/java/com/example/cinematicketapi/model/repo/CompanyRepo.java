package com.example.cinematicketapi.model.repo;


import com.example.cinematicketapi.model.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<Company,Integer> {
}
