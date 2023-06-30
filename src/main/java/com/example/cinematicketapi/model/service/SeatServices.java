package com.example.cinematicketapi.model.service;

import com.example.cinematicketapi.model.dto.SeatDto;
import com.example.cinematicketapi.model.dto.SellingSeatDto;
import com.example.cinematicketapi.model.dto.SellingSeatLevelDto;
import com.example.cinematicketapi.model.dto.SellingSeatsByTheatreDto;
import com.example.cinematicketapi.model.repo.SeatLevelRepo;
import com.example.cinematicketapi.model.repo.SeatRepo;
import com.example.cinematicketapi.model.repo.TheaterRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
//@Transactional(readOnly = true)
public class SeatServices {

    private final SeatRepo seatRepo;
    private final SeatLevelRepo seatLevelRepo;
    private final TheaterRepo theaterRepo;

    public SeatServices(SeatRepo seatRepo, SeatLevelRepo seatLevelRepo, TheaterRepo theaterRepo) {
        this.seatRepo = seatRepo;
        this.seatLevelRepo = seatLevelRepo;
        this.theaterRepo = theaterRepo;
    }

    public List<SeatDto> findByTheaterId(int id){
        return seatRepo.findByTheaterId(id);
    }


    public SellingSeatsByTheatreDto findTheaterWithSeat(int theatreId) {
//        List<SellingSeatLevelDto> seatLevels = seatLevelRepo.findSeatLevelsByTheaterId(theatreId);
//
//        seatLevels.stream().map(sl -> sl.seatLevelId()).map(i -> seatRepo.findSeatsById(i)).forEach(ssDtos -> {
//            for(var ssd : ssDtos) {
//                seatLevels.stream().map(l -> l.seats().add(ssd));
//            }
//        });

        var theater = theaterRepo.findById(theatreId);

        SellingSeatsByTheatreDto dto = new SellingSeatsByTheatreDto(theater.get().getTheatreName(), null);

        return dto;
    }
}
