package com.example.cinematicketapi.model.dto.form;

import java.time.LocalDate;

public record AddUpComingForm(
        String movieName,
        String production,
        String cast,
        String trailer,
        LocalDate date,
        String duration,
        String plot,
        String poster,
        int cinemaId
) {
}
