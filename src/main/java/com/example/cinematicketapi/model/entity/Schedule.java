package com.example.cinematicketapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "SCHEDULE")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private LocalTime startTime;

    @Temporal(TemporalType.TIME)
    @Column(nullable = false)
    private LocalTime endTime;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "now_showing_movie_id")
    private NowShowingMovies nowShowingMovies;
}
