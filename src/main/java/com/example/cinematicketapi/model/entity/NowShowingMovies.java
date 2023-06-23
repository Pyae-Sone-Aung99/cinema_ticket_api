package com.example.cinematicketapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "NOW_SHOWING_MOVIES")
public class NowShowingMovies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String title;
    @Column(nullable = false)
    private String poster;
    @Column(nullable = false)
    private String plot;
    @Column(nullable = false)
    private String trailer;
    @Column(nullable = false)
    private String cast;

    @Enumerated(EnumType.STRING)
    private MovieType type;

    @ManyToOne
    @JoinColumn(name = "branch_manager_id")
    private BranchManager branchManager;

    @ManyToOne()
    @JoinColumn(name = "theater_id")
    private Theater theater;

    @ManyToMany(mappedBy = "nowShowingMovies")
    private List<Schedule> schedules = new ArrayList<>();

    private enum MovieType{
        TWO_D,THREE_D
    }
}
