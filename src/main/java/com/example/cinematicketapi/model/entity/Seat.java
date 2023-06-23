package com.example.cinematicketapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "SEAT")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, name = "seat_name")
    private String seatName;
    @Column(nullable = false)
    private boolean available;

    @ManyToOne
    private SeatLevel level;

    @ManyToOne
    private Theater theater;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
