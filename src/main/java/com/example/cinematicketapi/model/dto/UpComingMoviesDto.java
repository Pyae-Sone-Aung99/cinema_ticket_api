package com.example.cinematicketapi.model.dto;

import com.example.cinematicketapi.model.entity.Cinema;
import com.example.cinematicketapi.model.entity.UpComingMovies;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpComingMoviesDto {
    private int id;

    private String movieName;

    private String production;


    private String cast;


    private String trailer;

    private LocalDate date;

    private String duration;

    @Column(length = 10000)
    private String plot;

    private String poster;

    private Cinema cinema;

    public static UpComingMoviesDto from (UpComingMovies upm){
        return new UpComingMoviesDto(upm.getId(), upm.getMovieName(), upm.getProduction(),
                upm.getCast(), upm.getTrailer(),upm.getDate(), upm.getDuration(),
                upm.getPlot(), upm.getPoster(), upm.getCinema());
    }
}
