package com.example.cinematicketapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "BOOKING")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false,name = "phone_number")
    private String phoneNumber;
    @Column(nullable = false,name = "movie_name")
    private String movieName;
    @Column(nullable = false,name = "theatre_name")
    private String theatreName;
    @Column(nullable = false,name = "start_time")
    private String startTime;
    @Column(nullable = false,name = "end_time")
    private String endTime;
    @Column(nullable = false)
    private String date;
    @Column(name = "voucher_code")
    private String voucherCode;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "total_amount")
    private double totalAmount;


//    @OneToMany(mappedBy = "booking")
//    private List<Seat> seats = new ArrayList<>();
}
