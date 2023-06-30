package com.example.cinematicketapi.api;

import com.example.cinematicketapi.model.dto.SeatDto;
import com.example.cinematicketapi.model.dto.SellingSeatsByTheatreDto;
import com.example.cinematicketapi.model.service.SeatServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("seats")
public class SeatApi {

//    @Autowired
    private final SeatServices services;

    public SeatApi(SeatServices services) {
        this.services = services;
    }

    @GetMapping
    public List<SeatDto> findByTheaterId(@RequestParam("theaterId")int id){
        return services.findByTheaterId(id);
    }

    @GetMapping("seatByTheater")
    public SellingSeatsByTheatreDto findSeatByTheater(@RequestParam("theaterId")int id){
        return services.findTheaterWithSeat(id);
    }
}

























