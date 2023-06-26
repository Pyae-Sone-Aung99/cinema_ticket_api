package com.example.cinematicketapi.model.service;

import com.example.cinematicketapi.model.dto.CinemaDto;
import com.example.cinematicketapi.model.dto.CompanyDto;
import com.example.cinematicketapi.model.dto.form.AddCinemaForm;
import com.example.cinematicketapi.model.entity.Cinema;
import com.example.cinematicketapi.model.entity.Company;
import com.example.cinematicketapi.model.repo.CinemaRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CinemaServices {

    @Autowired
    private CinemaRepo cinemaRepo;

    @Autowired
    private CompanyServices companyServices;

    public CinemaDto save(@Valid Cinema cinema){
        return CinemaDto.from(cinemaRepo.save(cinema));
    }

    public List<CinemaDto> findAll(){
        return cinemaRepo.findAll().stream().map(a -> CinemaDto.from(a)).toList();
    }

    public void remove(int id){
        cinemaRepo.deleteById(id);
    }

    @Transactional
    public CinemaDto update(int id,@Valid AddCinemaForm form){
        return CinemaDto.from(cinemaRepo.findById(id).map(acc -> {
            acc.setCinemaName(form.cinemaName());
            acc.setLocation(form.location());
            acc.setPhoneNumber(form.phoneNumber());
            acc.setUserName(form.userName());
            acc.setPassword(form.password());
            acc.setRole(form.role());
            Company company = companyServices.findById(form.companyId());
            acc.setCompany(company);
            return acc;
        }).orElseThrow(EntityNotFoundException::new));
    }

    public Cinema findByBranchManagerId(int id){
        return cinemaRepo.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public List<CinemaDto> findByCompanyId(int id){
        return cinemaRepo.findByCompanyId(id);
    }
}
























