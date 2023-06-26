package com.example.cinematicketapi.model.dto;

import com.example.cinematicketapi.model.entity.Cinema;
import com.example.cinematicketapi.model.entity.NowShowingMovies;
import com.example.cinematicketapi.model.entity.SeatLevel;
import com.example.cinematicketapi.model.entity.Theater;
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

    public static TheaterDto from(Theater te){
        return new TheaterDto(te.getId(), te.getTheatreName(),te.getSoundSystem(),
                te.getCinema());
    }
}
