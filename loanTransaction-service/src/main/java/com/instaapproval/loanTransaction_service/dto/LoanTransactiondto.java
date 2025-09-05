package com.instaapproval.loanTransaction_service.dto;

import com.instaapproval.loanTransaction_service.entity.LoanStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
@Data
public class LoanTransactiondto {

    private Long  applicationid;

    private Long CustomerID;

    private BigDecimal loanamount;

    private LocalDate applicationdate;
    private LoanStatus status;

    private String remarks;
    private String filelink;
}
