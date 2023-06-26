package com.example.cinematicketapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "COMPANY")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, name = "company_name")
    private String companyName;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phoneNumber;
    @Column(nullable = false, unique = true, name = "user_name")
    private String userName;
    @Column(nullable = false, unique = true)
    private String password;
    @Column(nullable = false)
    private String role;

//    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
//    private List<Cinema> cinemas = new ArrayList<>();

}
