package com.example.cinematicketapi.model.dto.form;

public record AddStaffAccountForm(
        String userName,
        String password,
        String staffName,
        String phoneNumber,
        String email,
        String role,
        int cinemaId
) {
}
