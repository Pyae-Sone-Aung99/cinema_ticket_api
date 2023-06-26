package com.example.cinematicketapi.model.dto.form;

import com.example.cinematicketapi.model.entity.NowShowingMovies;
import com.example.cinematicketapi.model.entity.Schedule;
import com.example.cinematicketapi.model.entity.Theater;

import java.util.List;

public record AddNowShowingForm(
    String title,
    String poster,
    String plot,
    String trailer,
    String cast,
    String type,
    int cinemaId,
    int theaterId,
    List<Schedule> schedules
) {
}
