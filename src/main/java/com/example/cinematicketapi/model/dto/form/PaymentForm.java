package com.example.cinematicketapi.model.dto.form;

import com.example.cinematicketapi.model.entity.Seat;

public record PaymentForm(
        String name,
        String email,
        String phoneNumber,
        String movieName,
        String theaterName,
        String startTime,
        String endTime,
        String date,
        String voucherCode,
        String paymentMethod,
        double totalAmount,
        Seat seats
) {
}
