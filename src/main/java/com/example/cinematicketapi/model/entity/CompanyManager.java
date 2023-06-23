package com.example.cinematicketapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "COMPANY_MANAGER")
public class CompanyManager {	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true, name = "user_name")
    private String userName;
    @Column(nullable = false, unique = true)
    private String password;
    @Column(nullable = false)
    private String role;

    @OneToMany(mappedBy = "companyManager")
    private List<Cinema> cinemas = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "company_id")
    private Company company;

}
