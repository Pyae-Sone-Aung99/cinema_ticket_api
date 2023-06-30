package com.example.cinematicketapi.model.dto;

import com.example.cinematicketapi.model.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TheaterDto {
    private int id;

    private String theatreName;

    private String soundSystem;

    private Cinema cinema;


//    private List<NowShowingMovies> nowShowingMovies;
//
//
//    private List<SeatLevel> seatLevels;
//    private List<Seat> seats;
    public static TheaterDto from(Theater te){
        return new TheaterDto(te.getId(), te.getTheatreName(),te.getSoundSystem(),
                te.getCinema());
    }
}
//,te.getSeatLevels(),te.getSeats()