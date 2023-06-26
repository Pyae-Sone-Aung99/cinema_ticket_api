package com.example.cinematicketapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "THEATRE")
public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, name = "treatre_name")
    private String theatreName;
    @Column(nullable = false, name = "sound_system")
    private String soundSystem;


    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

//    @OneToMany(mappedBy = "theater")
//    private List<NowShowingMovies> nowShowingMovies = new ArrayList<>();
//
//    @OneToMany(mappedBy = "theater")
//    private List<SeatLevel> seatLevels = new ArrayList<>();

}
