package com.example.cinematicketapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "UPCOMING_MOVIE")
public class UpComingMovies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, name = "movie_name")
    private String movieName;
    @Column(nullable = false)
    private String production;

    @Column(nullable = false)
    private String cast;

    @Column(nullable = false)
    private String trailer;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = false)
    private String duration;
    @Column(nullable = false)
    private String plot;
    @Column(nullable = false)
    private String poster;
    @ManyToOne
    @JoinColumn(name = "cineam_id")
    private Cinema cinema;
}
