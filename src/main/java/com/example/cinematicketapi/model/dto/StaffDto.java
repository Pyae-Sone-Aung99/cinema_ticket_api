package com.example.cinematicketapi.model.dto;

import com.example.cinematicketapi.model.entity.Cinema;
import com.example.cinematicketapi.model.entity.Staff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StaffDto {

    private int id;

    private String userName;

    private String password;

    private String staffName;

    private String phoneNumber;

    private String email;

    private String role;

    private Cinema cinema;

    public static StaffDto from (Staff st){
        return new StaffDto(st.getId(), st.getUserName(), st.getPassword(), st.getStaffName(),st.getPhoneNumber(),
                st.getEmail(),st.getRole(),st.getCinema());
    }
}
