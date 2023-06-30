package com.example.cinematicketapi.model.dto;

import java.util.List;

public record SellingSeatsByTheatreDto(
        String theaterName,
        List<SellingSeatLevelDto> seatLevels
) {
}
