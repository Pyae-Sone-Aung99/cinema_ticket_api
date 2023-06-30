package com.example.cinematicketapi.api;

import com.example.cinematicketapi.model.dto.TheaterDto;
import com.example.cinematicketapi.model.dto.form.AddTheatreForm;
import com.example.cinematicketapi.model.entity.Theater;
import com.example.cinematicketapi.model.service.TheaterServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("theater")
public class TheaterApi {
    @Autowired
    private final TheaterServices services;

    public TheaterApi(TheaterServices services) {
        this.services = services;
    }

    @PostMapping
    public TheaterDto create(@RequestBody @Validated AddTheatreForm form, BindingResult result){
        if (result.hasErrors()){
            throw new EntityNotFoundException();
        }
        return services.save(form);
    }

    @GetMapping
    public List<TheaterDto> findAll(){
        return services.findAll();
    }
    @GetMapping("/details/{id}")
    public Theater findById(@PathVariable int id){
        return services.findById(id);
    }

    @GetMapping("/searchByBmId")
    public List<TheaterDto> findByBranchManagerId(@RequestParam("cmId")int id){
        return services.findByBranchManagerId(id);
    }

//    Duplicate Seats
    @PatchMapping("{id}")
    public TheaterDto update(@PathVariable int id,@RequestBody @Validated AddTheatreForm form,BindingResult result){
        if (result.hasErrors()){
            throw new EntityNotFoundException();
        }
        return services.update(id,form);
    }

//    Not working
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        services.remove(id);
    }
}





























