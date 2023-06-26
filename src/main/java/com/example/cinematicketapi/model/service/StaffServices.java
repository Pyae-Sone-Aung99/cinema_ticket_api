package com.example.cinematicketapi.model.service;

import com.example.cinematicketapi.model.dto.StaffDto;
import com.example.cinematicketapi.model.dto.form.AddCinemaForm;
import com.example.cinematicketapi.model.dto.form.AddStaffAccountForm;
import com.example.cinematicketapi.model.entity.Cinema;
import com.example.cinematicketapi.model.entity.Staff;
import com.example.cinematicketapi.model.repo.StaffRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StaffServices {

    @Autowired
    private final StaffRepo staffRepo;

    @Autowired
    private final CinemaServices cinemaServices;

    public StaffServices(StaffRepo staffRepo, CinemaServices cinemaServices) {
        this.staffRepo = staffRepo;
        this.cinemaServices = cinemaServices;
    }

    public StaffDto save(@Valid AddStaffAccountForm form){
        Staff staff = new Staff();
        staff.setUserName(form.userName());
        staff.setPassword(form.password());
        staff.setEmail(form.email());
        staff.setPhoneNumber(form.phoneNumber());
        staff.setStaffName(form.staffName());
        staff.setRole(form.role());
        Cinema cinema = cinemaServices.findByBranchManagerId(form.cinemaId());
        staff.setCinema(cinema);
        return StaffDto.from(staffRepo.save(staff));
    }

    public List<StaffDto> findByBranchManagerId(int id){
        return staffRepo.findByCinemaId(id);
    }

    public void remove(int id){
        staffRepo.deleteById(id);
    }

    @Transactional
    public StaffDto update(int id, @Valid AddStaffAccountForm form){
        return StaffDto.from(staffRepo.findById(id).map(ele -> {
            ele.setUserName(form.userName());
            ele.setPassword(form.password());
            ele.setEmail(form.email());
            ele.setPhoneNumber(form.phoneNumber());
            ele.setStaffName(form.staffName());
            ele.setRole(form.role());
            Cinema cinema = cinemaServices.findByBranchManagerId(form.cinemaId());
            ele.setCinema(cinema);
            return ele;
        }).orElseThrow(EntityNotFoundException::new));
    }
}























