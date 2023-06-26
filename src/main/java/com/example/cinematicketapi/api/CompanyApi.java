package com.example.cinematicketapi.api;

import com.example.cinematicketapi.model.dto.CompanyDto;
import com.example.cinematicketapi.model.dto.form.AddCompanyForm;
import com.example.cinematicketapi.model.entity.Company;
import com.example.cinematicketapi.model.service.CompanyServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.naming.Binding;
import java.util.List;

@RestController
@RequestMapping("companymanager")
public class CompanyApi {

    @Autowired
    private CompanyServices services;

    @PostMapping
    public CompanyDto create(@RequestBody @Validated AddCompanyForm form, BindingResult result){
        if (result.hasErrors()){
            throw new EntityNotFoundException();
        }

        return services.save(form);
    }

    @GetMapping
    public List<CompanyDto> findAll(){
        return services.findAll();
    }

    @DeleteMapping({"{id}"})
    public void delete(@PathVariable int id){
        services.remove(id);
    }

    @PutMapping("{id}")
    public CompanyDto update(@PathVariable int id, @RequestBody @Validated AddCompanyForm form, BindingResult result){
        if (result.hasErrors())
            throw new EntityNotFoundException();

        return services.update(id,form);
    }

}

























