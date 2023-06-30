package com.example.cinematicketapi.model.dto;

import com.example.cinematicketapi.model.entity.*;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaDto {

    private int id;

    private String cinemaName;

    private String location;
    private String phoneNumber;
    private String userName;
    private String password;
    private String role;
    private Company company;

    public static CinemaDto from(Cinema cn){
        return new CinemaDto(cn.getId(), cn.getCinemaName(), cn.getLocation(), cn.getPhoneNumber(),cn.getUserName(),cn.getPassword(),
                cn.getRole(),cn.getCompany());
    }

}
