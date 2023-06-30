package com.example.cinematicketapi.model.dto;

import java.util.ArrayList;
import java.util.List;

public record SellingSeatLevelDto(
        int seatLevelId,
        String level,
        int quantity,
        double price,
        List<SellingSeatDto> seats
) {

    public SellingSeatLevelDto(int seatLevelId,
                                String level,
                                int quantity,
                                double price) {
        this(seatLevelId, level, quantity, price, new ArrayList<SellingSeatDto>());
    }
}
