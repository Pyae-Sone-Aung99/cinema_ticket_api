package com.example.cinematicketapi.model.dto;

import com.example.cinematicketapi.model.entity.Booking;
import com.example.cinematicketapi.model.entity.Seat;
import com.example.cinematicketapi.model.entity.SeatLevel;
import com.example.cinematicketapi.model.entity.Theater;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeatDto {

    private int id;

    private String seatName;

    private boolean available;


    private SeatLevel level;


    private Theater theater;

//    private Booking booking;

    private static SeatDto from(Seat se){
        return new SeatDto(se.getId(), se.getSeatName(), se.isAvailable(), se.getLevel(),
                se.getTheater());
    }
}
//,se.getBooking()