package com.example.cinematicketapi.model.entity;

import com.example.cinematicketapi.model.dto.CompanyDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "CINEMA")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, name = "cinema_name")
    private String cinemaName;
    @Column(nullable = false)
    private String location;
    @Column(nullable = false,name = "phone_number")
    private String phoneNumber;
    @Column(nullable = false, name="user_name")
    private String userName;
    @Column(nullable = false)
    private String password;
    private String role;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

//    @OneToMany(mappedBy = "cinema")
//    private List<Theater> theaters = new ArrayList<>();
//
//    @OneToMany(mappedBy = "cinema")
//    private List<NowShowingMovies> nowShowingMovies = new ArrayList<>();
//
//    @OneToMany(mappedBy = "cinema")
//    private List<UpComingMovies> upComingMovies = new ArrayList<>();

}
