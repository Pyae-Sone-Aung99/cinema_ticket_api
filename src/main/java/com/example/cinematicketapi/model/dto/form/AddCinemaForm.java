package com.example.cinematicketapi.model.dto.form;

import com.example.cinematicketapi.model.entity.Cinema;



public record AddCinemaForm(
    String cinemaName,
    String location,
    String phoneNumber,
    String userName,
    String password,
    String role,
    int companyId
) {
}
