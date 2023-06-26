package com.example.cinematicketapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "STAFF")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false,name = "user_name")
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,name = "staff_name")
    private String staffName;
    @Column(nullable = false,name = "phone_number")
    private String phoneNumber;
    @Column(nullable = false)
    private String email;
    private String role;
    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private Cinema cinema;
}
