package com.example.cinematicketapi.model.dto;

import com.example.cinematicketapi.model.entity.Booking;
import com.example.cinematicketapi.model.entity.Seat;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDto {

    private int id;
    private String name;

    private String email;
    private String phoneNumber;
    private String movieName;

    private String theaterName;

    private String startTime;
    private String endTime;
    private String date;
    private String voucherCode;
    private String paymentMethod;
    private double totalAmount;
//    private List<Seat> seats;

    private static BookingDto from (Booking book){
        return new BookingDto(book.getId(),book.getName(),book.getEmail(),book.getPhoneNumber(),book.getMovieName(),
                book.getTheatreName(),book.getStartTime(),book.getEndTime(),book.getDate(),
                book.getPaymentMethod(),book.getVoucherCode(),book.getTotalAmount());
    }


//,book.getSeats()
}
