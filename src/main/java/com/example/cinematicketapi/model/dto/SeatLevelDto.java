package com.example.cinematicketapi.model.dto;


import com.example.cinematicketapi.model.entity.Seat;
import com.example.cinematicketapi.model.entity.SeatLevel;
import com.example.cinematicketapi.model.entity.Theater;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeatLevelDto {

    private int id;

    private String level;

    private int quantity;

    private double price;


    private Theater theater;


//    private List<Seat> seats;

    public static SeatLevelDto from (SeatLevel sl){
        return new SeatLevelDto(sl.getId(), sl.getLevel(), sl.getQuantity(), sl.getPrice(),
                sl.getTheater());
    }


}
