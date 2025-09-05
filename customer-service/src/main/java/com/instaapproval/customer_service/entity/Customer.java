package com.instaapproval.customer_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CustomerID;
    private String name;
    private String email;
    private String phone;
    private String password;
    private String address;
    private LocalDate dateofBirth;
    private Integer cib;
    private  LocalDate registrationDate;


  //  CustomerID (PK), Name, Email, Phone, Address, DateOfBirth, CIBILScore, RegistrationDate

}
