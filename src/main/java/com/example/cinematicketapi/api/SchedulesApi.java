package com.example.cinematicketapi.api;

import com.example.cinematicketapi.model.dto.ScheduleDto;
import com.example.cinematicketapi.model.service.SchedulesServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("schedules")
public class SchedulesApi {

    private final SchedulesServices services;

    public SchedulesApi(SchedulesServices services) {
        this.services = services;
    }

    @GetMapping("{id}")
    public List<ScheduleDto> findByNowShowingId(@PathVariable int id){
        return services.findByNowShowingId(id);
    }
}
