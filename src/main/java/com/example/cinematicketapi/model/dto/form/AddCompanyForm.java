package com.example.cinematicketapi.model.dto.form;

import com.example.cinematicketapi.model.entity.Company;

public record AddCompanyForm(
        String companyName,
        String email,
        String phoneNumber,
        String userName,
        String password,
        String role
) {
    public Company entity(){
        var company = new Company();
        company.setCompanyName(companyName);
        company.setEmail(email);
        company.setPhoneNumber(phoneNumber);
        company.setUserName(userName);
        company.setPassword(password);
        company.setRole(role);
        return company;
    }
}
