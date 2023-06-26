package com.example.cinematicketapi.api;

import com.example.cinematicketapi.model.dto.StaffDto;
import com.example.cinematicketapi.model.dto.form.AddStaffAccountForm;
import com.example.cinematicketapi.model.service.StaffServices;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("staff")
public class StaffApi {

    @Autowired
    private final StaffServices services;

    public StaffApi(StaffServices services) {
        this.services = services;
    }

    @PostMapping
    public StaffDto create(@RequestBody @Validated AddStaffAccountForm form, BindingResult result){
        if (result.hasErrors()){
            throw new EntityNotFoundException();
        }
        return services.save(form);
    }

    @GetMapping("/searchByBmId")
    public List<StaffDto> findByBranchManagerId(@RequestParam("bmId")int id){
        return services.findByBranchManagerId(id);
    }

    @PutMapping("{id}")
    public StaffDto update(@PathVariable int id,@RequestBody @Validated AddStaffAccountForm form,BindingResult result){
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



























