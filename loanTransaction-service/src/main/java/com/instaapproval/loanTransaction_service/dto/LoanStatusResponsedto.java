package com.instaapproval.loanTransaction_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoanStatusResponsedto {

    private Long CustomerID;
    private String status;


}
