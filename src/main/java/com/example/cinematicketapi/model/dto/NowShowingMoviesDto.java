package com.example.cinematicketapi.model.dto;

import com.example.cinematicketapi.model.entity.Cinema;
import com.example.cinematicketapi.model.entity.NowShowingMovies;
import com.example.cinematicketapi.model.entity.Schedule;
import com.example.cinematicketapi.model.entity.Theater;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NowShowingMoviesDto {
    private int id;
    private String title;
    private String poster;
    private String plot;
    private String trailer;
    private String cast;
    private String type;
    private Cinema cinema;
    private Theater theater;



    public static NowShowingMoviesDto from(NowShowingMovies nsm){
        return new NowShowingMoviesDto(nsm.getId(), nsm.getTitle(), nsm.getPoster(),
                nsm.getPlot(), nsm.getTrailer(), nsm.getCast(),nsm.getType(),
                nsm.getCinema(),nsm.getTheater());
    }
}
