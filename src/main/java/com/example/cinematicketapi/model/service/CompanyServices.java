package com.example.cinematicketapi.model.service;

import com.example.cinematicketapi.model.dto.CompanyDto;
import com.example.cinematicketapi.model.dto.form.AddCompanyForm;
import com.example.cinematicketapi.model.entity.Company;
import com.example.cinematicketapi.model.repo.CompanyRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyServices {

    @Autowired
    private CompanyRepo companyRepo;

    public CompanyDto save(@Valid AddCompanyForm form){
        return CompanyDto.from(companyRepo.save(form.entity()));
    }

    public List<CompanyDto> findAll(){
        return companyRepo.findAll().stream().map(a -> CompanyDto.from(a)).toList();
    }

    public void remove(int id){
        companyRepo.deleteById(id);
    }

    public CompanyDto update(int id,@Valid AddCompanyForm form){
        return companyRepo.findById(id).map(acc -> {
            acc.setCompanyName(form.companyName());
            acc.setEmail(form.email());
            acc.setPhoneNumber(form.phoneNumber());
            acc.setUserName(form.userName());
            acc.setPassword(form.password());
            acc.setRole(form.role());
            return CompanyDto.from(acc);
        }).orElseThrow(EntityNotFoundException::new);
    }

    public Company findById(int id){
        return companyRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Company not found"));
    }

}





















