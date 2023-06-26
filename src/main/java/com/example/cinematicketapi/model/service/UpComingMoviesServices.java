package com.example.cinematicketapi.model.service;


import com.example.cinematicketapi.model.dto.UpComingMoviesDto;
import com.example.cinematicketapi.model.dto.form.AddUpComingForm;
import com.example.cinematicketapi.model.entity.Cinema;
import com.example.cinematicketapi.model.entity.UpComingMovies;
import com.example.cinematicketapi.model.repo.UpComingMoviesRepo;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UpComingMoviesServices {

    @Autowired
    private final UpComingMoviesRepo upComingMoviesRepo;
    @Autowired
    private final CinemaServices cinemaServices;

    public UpComingMoviesServices(UpComingMoviesRepo upComingMoviesRepo,CinemaServices cinemaServices) {
        this.upComingMoviesRepo = upComingMoviesRepo;
        this.cinemaServices = cinemaServices;
    }

    public UpComingMoviesDto save(@Valid AddUpComingForm form){
        UpComingMovies upComingMovies = new UpComingMovies();
        upComingMovies.setCast(form.cast());
        upComingMovies.setDate(form.date());
        upComingMovies.setDuration(form.duration());
        upComingMovies.setMovieName(form.movieName());
        upComingMovies.setPlot(form.plot());
        upComingMovies.setPoster(form.poster());
        upComingMovies.setProduction(form.production());
        upComingMovies.setTrailer(form.trailer());
        Cinema cinema = cinemaServices.findByBranchManagerId(form.cinemaId());
        upComingMovies.setCinema(cinema);
        return UpComingMoviesDto.from(upComingMoviesRepo.save(upComingMovies));
    }

    public List<UpComingMoviesDto> findAll(){
        return upComingMoviesRepo.findAll().stream().map(ele -> UpComingMoviesDto.from(ele)).toList();
    }

    public UpComingMoviesDto findById(int id){
        return UpComingMoviesDto.from(upComingMoviesRepo.findById(id).orElseThrow(IllegalArgumentException::new));
    }

//    Cinema id
    public List<UpComingMoviesDto> findByBranchManagerId(int id){
        return upComingMoviesRepo.findByCinemaId(id);
    }

    @Transactional
    public UpComingMoviesDto update(int id,@Valid AddUpComingForm form){
        return UpComingMoviesDto.from(upComingMoviesRepo.findById(id).map(ele -> {
            ele.setCast(form.cast());
            ele.setDate(form.date());
            ele.setDuration(form.duration());
            ele.setMovieName(form.movieName());
            ele.setPlot(form.plot());
            ele.setPoster(form.poster());
            ele.setProduction(form.production());
            ele.setTrailer(form.trailer());
            Cinema cinema = cinemaServices.findByBranchManagerId(form.cinemaId());
            ele.setCinema(cinema);
            return ele;
        }).orElseThrow(EntityNotFoundException::new));
    }

    public void remove(int id){
        upComingMoviesRepo.deleteById(id);
    }
}


























