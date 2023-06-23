package com.example.cinematicketapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

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

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "company_manager_id")
    private CompanyManager companyManager;

    @OneToOne(optional = false,mappedBy = "cinema")
    private BranchManager branchManager;

}
