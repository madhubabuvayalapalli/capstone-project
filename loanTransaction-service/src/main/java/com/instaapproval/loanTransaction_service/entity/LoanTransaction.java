package com.instaapproval.loanTransaction_service.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
public class LoanTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long  applicationid;

    private Long CustomerID;

    private BigDecimal loanamount;

    private LocalDate applicationdate;
    @Enumerated(EnumType.STRING)
    private LoanStatus status;

    private String remarks;

    private String filelink;


 //   ApplicationID (PK), CustomerID (FK), LoanAmount, ApplicationDate, Status (Pending/Approved/Rejected), Remarks
}
