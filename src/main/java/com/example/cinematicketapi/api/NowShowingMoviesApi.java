package com.example.cinematicketapi.api;

import com.example.cinematicketapi.model.dto.NowShowingMoviesDto;
import com.example.cinematicketapi.model.dto.TheaterDto;
import com.example.cinematicketapi.model.dto.UpComingMoviesDto;
import com.example.cinematicketapi.model.dto.form.AddNowShowingForm;
import com.example.cinematicketapi.model.dto.form.AddTheatreForm;
import com.example.cinematicketapi.model.entity.NowShowingMovies;
import com.example.cinematicketapi.model.service.NowShowingMoviesServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("nowshowing")
public class NowShowingMoviesApi {
    @Autowired
    private NowShowingMoviesServices services;


    @PostMapping
    public NowShowingMoviesDto create(@RequestBody @Validated AddNowShowingForm form, BindingResult result){
        if (result.hasErrors()){
            throw new EntityNotFoundException();
        }
        return services.save(form);
    }

    @GetMapping
    public List<NowShowingMoviesDto> findAll(){
        return services.findAll();
    }

    @GetMapping("/details/{id}")
    public NowShowingMovies findById(@PathVariable int id){
        return services.findById(id);
    }

    @GetMapping("/searchByBmId")
    public List<NowShowingMoviesDto> findByBranchManagerId(@RequestParam("cmId")int id){
        return services.findByBranchManagerId(id);
    }

    @PatchMapping("{id}")
    public NowShowingMoviesDto update(@PathVariable int id, @RequestBody @Validated AddNowShowingForm form, BindingResult result){
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


























