package com.example.cinematicketapi.model.dto;

import com.example.cinematicketapi.model.entity.NowShowingMovies;
import com.example.cinematicketapi.model.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleDto {

    private int id;

    private LocalTime startTime;


    private LocalTime endTime;


    private LocalDate date;


    private NowShowingMovies nowShowingMovies;

    public static ScheduleDto from(Schedule scd){
        return new ScheduleDto(scd.getId(), scd.getStartTime(),scd.getEndTime(),scd.getDate(),
                scd.getNowShowingMovies());
    }
}
