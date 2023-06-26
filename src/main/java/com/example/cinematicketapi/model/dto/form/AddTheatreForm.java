package com.example.cinematicketapi.model.dto.form;

import com.example.cinematicketapi.model.entity.SeatLevel;

import java.util.List;

public record AddTheatreForm(
        String theatreName,
        String soundSystem,
        String cinema,
        List<SeatLevel> seatLevels,
        int cinemaId
//        String seatLevels,
//        int quantity,
//        int price
) {
}
