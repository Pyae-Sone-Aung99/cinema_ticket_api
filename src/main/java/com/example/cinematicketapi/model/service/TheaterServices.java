package com.example.cinematicketapi.model.service;

import com.example.cinematicketapi.model.dto.SeatLevelDto;
import com.example.cinematicketapi.model.dto.TheaterDto;
import com.example.cinematicketapi.model.dto.form.AddTheatreForm;
import com.example.cinematicketapi.model.entity.Cinema;
import com.example.cinematicketapi.model.entity.Seat;
import com.example.cinematicketapi.model.entity.SeatLevel;
import com.example.cinematicketapi.model.entity.Theater;
import com.example.cinematicketapi.model.repo.SeatLevelRepo;
import com.example.cinematicketapi.model.repo.SeatRepo;
import com.example.cinematicketapi.model.repo.TheaterRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TheaterServices {

    @Autowired
    private final TheaterRepo theaterRepo;

    @Autowired
    private final SeatLevelRepo seatLevelRepo;

    @Autowired
    private final CinemaServices cinemaServices;

    @Autowired
    private final SeatRepo seatRepo;

    public TheaterServices(TheaterRepo theaterRepo,SeatLevelRepo seatLevelRepo,CinemaServices cinemaServices,
                           SeatRepo seatRepo) {
        this.theaterRepo = theaterRepo;
        this.seatLevelRepo = seatLevelRepo;
        this.cinemaServices = cinemaServices;
        this.seatRepo = seatRepo;
    }

    @Transactional
    public TheaterDto save(@Valid AddTheatreForm form){
        Theater theater = new Theater();
        theater.setTheatreName(form.theatreName());
        theater.setSoundSystem(form.soundSystem());

        for(SeatLevel seatLevel : form.seatLevels()){
            seatLevel.setTheater(theater);
            SeatLevelDto.from(seatLevelRepo.save(seatLevel));

            for (int i = 1;i <= seatLevel.getQuantity();i++){
                String seatName = seatLevel.getLevel() + i;
                Seat seat = new Seat();
                seat.setSeatName(seatName);
                seat.setTheater(theater);
                seat.setLevel(seatLevel);
                seatRepo.save(seat);
            }
        }
        Cinema cinema = cinemaServices.findByBranchManagerId(form.cinemaId());
        theater.setCinema(cinema);
        return TheaterDto.from(theaterRepo.save(theater));
    }

    public List<TheaterDto> findByBranchManagerId(int id){
        return theaterRepo.findByCinemaId(id);
    }

    public Theater findById(int id){
        return theaterRepo.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    @Transactional
    public TheaterDto update(int id,@Valid AddTheatreForm form){
        return TheaterDto.from(theaterRepo.findById(id).map(ele -> {
            ele.setTheatreName(form.theatreName());
            ele.setSoundSystem(form.soundSystem());

            seatRepo.deleteSeatByTheaterId(ele.getId());
            seatLevelRepo.deleteSeatLevelByTheaterId(ele.getId());

            for(SeatLevel seatLevel : form.seatLevels()){
                seatLevel.setTheater(ele);
                SeatLevelDto.from(seatLevelRepo.save(seatLevel));

                for (int i = 1;i <= seatLevel.getQuantity();i++){
                    String seatName = seatLevel.getLevel() + i;
                    Seat seat = new Seat();
                    seat.setSeatName(seatName);
                    seat.setTheater(ele);
                    seat.setLevel(seatLevel);
                    seatRepo.save(seat);
                }
            }
            Cinema cinema = cinemaServices.findByBranchManagerId(form.cinemaId());
            ele.setCinema(cinema);
            return ele;
        }).orElseThrow(EntityNotFoundException::new));
    }

    public void remove(int id){
        seatRepo.deleteSeatByTheaterId(id);
        seatLevelRepo.deleteSeatLevelByTheaterId(id);
        theaterRepo.deleteById(id);
    }
}
























