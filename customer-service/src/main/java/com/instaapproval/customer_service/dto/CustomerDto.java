package com.instaapproval.customer_service.dto;

import lombok.Data;

import java.time.LocalDate;
@Data
public class CustomerDto {
    private Long CustomerID;
    private String name;
    private String email;
    private String phone;
     private String password;
    private String address;
    private LocalDate dateofBirth;
    private Integer cib;
    private  LocalDate registrationDate;
}
