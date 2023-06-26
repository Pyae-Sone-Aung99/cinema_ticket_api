package com.example.cinematicketapi.api;


import com.example.cinematicketapi.model.dto.UpComingMoviesDto;
import com.example.cinematicketapi.model.dto.form.AddUpComingForm;
import com.example.cinematicketapi.model.entity.UpComingMovies;
import com.example.cinematicketapi.model.repo.UpComingMoviesRepo;
import com.example.cinematicketapi.model.service.UpComingMoviesServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("upcoming")
public class UpComingMoviesApi {

    private final UpComingMoviesServices services;

    public UpComingMoviesApi(UpComingMoviesServices services) {
        this.services = services;
    }

    @PostMapping
    public UpComingMoviesDto create(@RequestBody @Validated AddUpComingForm form, BindingResult result){
        if (result.hasErrors()){
            throw new EntityNotFoundException();
        }
        return services.save(form);
    }

    @GetMapping
    public List<UpComingMoviesDto> findAll(){
        return services.findAll();
    }

    @GetMapping("/details/{id}")
    public UpComingMoviesDto findById(@PathVariable int id){
        return services.findById(id);
    }

    @GetMapping("/searchByBmId")
    public List<UpComingMoviesDto> findByBranchManagerId(@RequestParam("cmId")int id){
        return services.findByBranchManagerId(id);
    }

    @PatchMapping("{id}")
    public UpComingMoviesDto update(@PathVariable int id,@RequestBody @Validated AddUpComingForm form,BindingResult result){
        if (result.hasErrors()){
            throw new EntityNotFoundException();
        }
        return services.update(id,form);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        services.remove(id);
    }

}





















