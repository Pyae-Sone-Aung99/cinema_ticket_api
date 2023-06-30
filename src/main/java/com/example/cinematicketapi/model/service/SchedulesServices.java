package com.example.cinematicketapi.model.service;

import com.example.cinematicketapi.model.dto.ScheduleDto;
import com.example.cinematicketapi.model.entity.Schedule;
import com.example.cinematicketapi.model.repo.ScheduleRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulesServices {

    private final ScheduleRepo scheduleRepo;

    public SchedulesServices(ScheduleRepo scheduleRepo) {
        this.scheduleRepo = scheduleRepo;
    }
    public List<ScheduleDto> findByNowShowingId(int id){
        return scheduleRepo.findByNowShowingMoviesId(id);
    }
}
