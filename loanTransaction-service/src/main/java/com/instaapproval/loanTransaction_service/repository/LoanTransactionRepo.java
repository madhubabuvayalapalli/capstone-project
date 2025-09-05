package com.instaapproval.loanTransaction_service.repository;

import com.instaapproval.loanTransaction_service.entity.LoanTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanTransactionRepo extends JpaRepository<LoanTransaction,Long> {






        @Query(value = "SELECT lt.status FROM loantransaction.loan_transaction lt WHERE lt.customerid = :customerId ORDER BY lt.applicationid DESC LIMIT 1", nativeQuery = true)
        String findLatestStatusByCustomerId(@Param("customerId") Long customerId);


}
