package com.example.cinematicketapi.model.service;

import com.example.cinematicketapi.model.dto.NowShowingMoviesDto;
import com.example.cinematicketapi.model.dto.ScheduleDto;
import com.example.cinematicketapi.model.dto.form.AddNowShowingForm;
import com.example.cinematicketapi.model.entity.Cinema;
import com.example.cinematicketapi.model.entity.NowShowingMovies;
import com.example.cinematicketapi.model.entity.Schedule;
import com.example.cinematicketapi.model.entity.Theater;
import com.example.cinematicketapi.model.repo.NowShowingMoviesRepo;
import com.example.cinematicketapi.model.repo.ScheduleRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NowShowingMoviesServices {

//    @Autowired
    private final NowShowingMoviesRepo nowShowingMoviesRepo;

//    @Autowired
    private final CinemaServices cinemaServices;

//    @Autowired
    private final TheaterServices theaterServices;

//    @Autowired
    private final ScheduleRepo scheduleRepo;

    public NowShowingMoviesServices(NowShowingMoviesRepo nowShowingMoviesRepo,CinemaServices cinemaServices,
                                    TheaterServices theaterServices,ScheduleRepo scheduleRepo) {
        this.nowShowingMoviesRepo = nowShowingMoviesRepo;
        this.cinemaServices = cinemaServices;
        this.theaterServices = theaterServices;
        this.scheduleRepo = scheduleRepo;
    }

    @Transactional
    public NowShowingMoviesDto save(@Valid AddNowShowingForm form){
        NowShowingMovies nowShowingMovies = new NowShowingMovies();
        nowShowingMovies.setCast(form.cast());
        nowShowingMovies.setPlot(form.plot());
        nowShowingMovies.setPoster(form.poster());
        nowShowingMovies.setTitle(form.title());
        nowShowingMovies.setTrailer(form.trailer());
        nowShowingMovies.setType(form.type());
        for (Schedule schedule : form.schedules()){
            schedule.setNowShowingMovies(nowShowingMovies);
            ScheduleDto.from(scheduleRepo.save(schedule));
        }
        Cinema cinema = cinemaServices.findByBranchManagerId(form.cinemaId());
        nowShowingMovies.setCinema(cinema);
        Theater theater = theaterServices.findById(form.theaterId());
        nowShowingMovies.setTheater(theater);
        return NowShowingMoviesDto.from(nowShowingMoviesRepo.save(nowShowingMovies));
    }

    public List<NowShowingMoviesDto> findAll(){
        return nowShowingMoviesRepo.findAll().stream().map(ele -> NowShowingMoviesDto.from(ele)).toList();
    }
    public NowShowingMovies findById(int id){
        return nowShowingMoviesRepo.findById(id).orElseThrow(IllegalArgumentException::new);
    }
//Cinema id
    public List<NowShowingMoviesDto> findByBranchManagerId(int id){
        return nowShowingMoviesRepo.findByCinemaId(id);
    }

    @Transactional
    public NowShowingMoviesDto update(int id,@Valid AddNowShowingForm form){
        return NowShowingMoviesDto.from(nowShowingMoviesRepo.findById(id).map(ele -> {
            ele.setCast(form.cast());
            ele.setPlot(form.plot());
            ele.setPoster(form.poster());
            ele.setTitle(form.title());
            ele.setTrailer(form.trailer());
            ele.setType(form.type());
            scheduleRepo.deleteScheduleByNowShowingMoviesId(form.cinemaId());
            for (Schedule schedule : form.schedules()){
                schedule.setNowShowingMovies(ele);
                ScheduleDto.from(scheduleRepo.save(schedule));
            }
            Cinema cinema = cinemaServices.findByBranchManagerId(form.cinemaId());
            ele.setCinema(cinema);
            Theater theater = theaterServices.findById(form.theaterId());
            ele.setTheater(theater);
            return ele;
        }).orElseThrow(EntityNotFoundException::new));
    }

    public void remove(int id){
        scheduleRepo.deleteScheduleByNowShowingMoviesId(id);
        nowShowingMoviesRepo.deleteById(id);
    }
}





























