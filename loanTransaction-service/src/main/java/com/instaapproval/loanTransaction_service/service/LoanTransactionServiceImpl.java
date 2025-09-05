package com.instaapproval.loanTransaction_service.service;

import com.instaapproval.loanTransaction_service.dto.LoanTransactiondto;
import com.instaapproval.loanTransaction_service.entity.Admin;
import com.instaapproval.loanTransaction_service.entity.LoanTransaction;
import com.instaapproval.loanTransaction_service.repository.AdminRepo;
import com.instaapproval.loanTransaction_service.repository.LoanTransactionRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanTransactionServiceImpl implements LoanTransactionService {
              @Autowired
              private LoanTransactionRepo loanTransactionRepo;
              @Autowired
              private AdminRepo adminRepo;

    public LoanTransaction postLoanApplication(LoanTransactiondto loanTransactiondto)
    {

        return loanTransaction_save(new LoanTransaction(),loanTransactiondto);
    }


    public LoanTransaction loanTransaction_save(LoanTransaction loanTransaction, LoanTransactiondto loanTransactiondto)
    {
        loanTransaction.setCustomerID(loanTransactiondto.getCustomerID());
        loanTransaction.setStatus(loanTransactiondto.getStatus());
        loanTransaction.setRemarks(loanTransactiondto.getRemarks());
        loanTransaction.setApplicationdate(loanTransactiondto.getApplicationdate());
        loanTransaction.setFilelink(loanTransaction.getFilelink());
        loanTransaction.setLoanamount(loanTransactiondto.getLoanamount());


        return   loanTransactionRepo.save(loanTransaction);
    }

    public List<LoanTransaction> getAll()
    {


        return loanTransactionRepo.findAll();
    }

    public LoanTransaction updatebyId(Long  applicationid,LoanTransactiondto loanTransactiondto)
    {

        Optional<LoanTransaction> loan=  loanTransactionRepo.findById(applicationid);
        if(loan.isPresent())
        {
            return   loanTransaction_save(loan.get(),loanTransactiondto);
        }
        else {
            throw new EntityNotFoundException(" customer is not found with customer_id"+ applicationid);
        }
    }

    public LoanTransaction getbyId(Long applicationid) {
        Optional<LoanTransaction> dr=  loanTransactionRepo.findById(applicationid);

        if(dr.isPresent()){
            return dr.get();
        }else {
            throw new EntityNotFoundException("customerr with the id is not found "+applicationid );
        }
    }

    public void delete(Long applicationid) {
        Optional<LoanTransaction> dr = loanTransactionRepo.findById(applicationid);

        if (dr.isPresent()) {
            loanTransactionRepo.deleteById(applicationid);
        } else {
            throw new EntityNotFoundException("Customer with the id is not found " + applicationid);
        }
    }

    public String checkLoanStatus(Long CustomerID){

        Optional<LoanTransaction> dr = loanTransactionRepo.findById(CustomerID);

        if (dr.isPresent()) {


            String status= loanTransactionRepo.findLatestStatusByCustomerId(CustomerID);
            return status;
        } else {
            throw new EntityNotFoundException("Customer with the id is not found " + CustomerID);
        }

    }

///==================================================================================================================
                         /// ADMIN SERVICES///

public Admin postAdminDetails(Admin admin)
{
    return adminRepo.save(admin);
}




}
