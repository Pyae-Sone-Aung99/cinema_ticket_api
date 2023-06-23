package com.example.cinematicketapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "BRANCH_MANAGER")
public class BranchManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, name="user_name")
    private String userName;
    @Column(nullable = false)
    private String password;

//    @OneToMany(mappedBy = "branchManager",cascade = CascadeType.PERSIST)
//    private List<Staff> stafList = new ArrayList<>();

    @OneToOne(optional = false)
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;

    @OneToMany(mappedBy = "branchManager")
    private List<Theater> theaters = new ArrayList<>();

    @OneToMany(mappedBy = "branchManager")
    private List<NowShowingMovies> nowShowingMovies = new ArrayList<>();

    @OneToMany(mappedBy = "branchManager")
    private List<UpComingMovies> upComingMovies = new ArrayList<>();
}
