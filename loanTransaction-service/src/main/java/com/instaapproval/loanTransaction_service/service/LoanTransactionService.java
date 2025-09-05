package com.instaapproval.loanTransaction_service.service;

import com.instaapproval.loanTransaction_service.dto.LoanTransactiondto;
import com.instaapproval.loanTransaction_service.entity.Admin;
import com.instaapproval.loanTransaction_service.entity.LoanTransaction;

import java.util.List;

public interface LoanTransactionService {

    public LoanTransaction postLoanApplication(LoanTransactiondto loanTransactiondto);
    public LoanTransaction loanTransaction_save(LoanTransaction loanTransaction, LoanTransactiondto loanTransactiondto);
    public List<LoanTransaction> getAll();

    public LoanTransaction updatebyId(Long  applicationid,LoanTransactiondto loanTransactiondto);

    public LoanTransaction getbyId(Long applicationid);

    public void delete(Long applicationid);
    public String checkLoanStatus(Long CustomerID);

    public Admin postAdminDetails(Admin admin);
}
