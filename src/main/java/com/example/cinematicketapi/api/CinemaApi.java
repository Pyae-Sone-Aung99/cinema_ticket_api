package com.example.cinematicketapi.api;

import com.example.cinematicketapi.model.dto.CinemaDto;
import com.example.cinematicketapi.model.dto.CompanyDto;
import com.example.cinematicketapi.model.dto.form.AddCinemaForm;
import com.example.cinematicketapi.model.entity.Cinema;
import com.example.cinematicketapi.model.entity.Company;
import com.example.cinematicketapi.model.repo.CinemaRepo;
import com.example.cinematicketapi.model.repo.CompanyRepo;
import com.example.cinematicketapi.model.service.CinemaServices;
import com.example.cinematicketapi.model.service.CompanyServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cinema")
public class CinemaApi {
    @Autowired
    private CinemaServices services;

    @Autowired
    private CompanyServices companyServices;

    @PostMapping
    public CinemaDto create(@RequestBody @Validated AddCinemaForm form, BindingResult result){
        if (result.hasErrors()){
            throw new EntityNotFoundException();
        }
        Cinema cinema = new Cinema();
        cinema.setCinemaName(form.cinemaName());
        cinema.setLocation(form.location());
        cinema.setPhoneNumber(form.phoneNumber());
        cinema.setUserName(form.userName());
        cinema.setPassword(form.password());
        cinema.setRole(form.role());
        Company company = companyServices.findById(form.companyId());
        cinema.setCompany(company);
        return services.save(cinema);
    }

    @GetMapping
    public List<CinemaDto> findAll(){
        return services.findAll();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        services.remove(id);
    }

    @PutMapping("{id}")
    public CinemaDto update(@PathVariable int id,@RequestBody @Validated AddCinemaForm form, BindingResult result){
        if (result.hasErrors()){
            throw new EntityNotFoundException();
        }
        return services.update(id,form);
    }

    @GetMapping("/searchByBmId")
    public Cinema findByBranchManagerId(@RequestParam("id") int id){
        return services.findByBranchManagerId(id);
    }

    @GetMapping("/searchByCmid")
    public List<CinemaDto> findByCompanyManagerId(@RequestParam("cmId")int id){
        return services.findByCompanyId(id);
    }
}






























