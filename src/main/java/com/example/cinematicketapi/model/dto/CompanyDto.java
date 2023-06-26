package com.example.cinematicketapi.model.dto;

import com.example.cinematicketapi.model.entity.Cinema;
import com.example.cinematicketapi.model.entity.Company;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

    private int id;

    private String companyName;

    private String email;

    private String phoneNumber;
    private String userName;
    private String password;
    private String role;




    public static CompanyDto from (Company cp){
        return new CompanyDto(cp.getId(), cp.getCompanyName(), cp.getEmail(), cp.getPhoneNumber(),
                cp.getUserName(),cp.getPassword(),cp.getRole());
    }


}
