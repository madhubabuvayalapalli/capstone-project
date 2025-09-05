package com.instaapproval.loanTransaction_service.controller;

import com.instaapproval.loanTransaction_service.dto.LoanStatusResponsedto;
import com.instaapproval.loanTransaction_service.dto.LoanTransactiondto;
import com.instaapproval.loanTransaction_service.entity.Admin;
import com.instaapproval.loanTransaction_service.entity.LoanTransaction;
import com.instaapproval.loanTransaction_service.service.LoanTransactionService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/loans")
@CrossOrigin("*")
public class LoanTransactionController {

    @Autowired
    private LoanTransactionService loanTransactionService;
    @PostMapping("/apply")
    public ResponseEntity<?> save(@RequestBody LoanTransactiondto loanTransactiondto)
    {
        LoanTransaction d= loanTransactionService.postLoanApplication(loanTransactiondto);
        if(d!=null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{applicationid}")
    public ResponseEntity<?> update(@PathVariable Long applicationid, @RequestBody LoanTransactiondto loanTransactiondto) {
        try {
            LoanTransaction d = loanTransactionService.updatebyId(applicationid,loanTransactiondto);
            return  ResponseEntity.ok(d);
        } catch (EntityNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
//		catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong ");
//		}
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }

    }


    @GetMapping("/all")
    public ResponseEntity<?> getAll()
    {


        return  ResponseEntity.ok(loanTransactionService.getAll());


    }












    @GetMapping("/{applicationid}")
    public ResponseEntity<?> getbyid(@PathVariable Long applicationid)
    {

        try {
            return ResponseEntity.ok(loanTransactionService.getbyId(applicationid));
        }
        catch(EntityNotFoundException ex){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");

        }

    }


    @DeleteMapping("/{applicationid}")
    public   ResponseEntity<?> delete(@PathVariable Long applicationid)
    {


        try {
            loanTransactionService.delete(applicationid);
            return ResponseEntity.ok("deleted successfully");
        }
        catch(EntityNotFoundException ex){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");

        }


    }


//    @GetMapping("/status/{CustomerID}")
//    public   String getLoanStatus(@PathVariable Long CustomerID)
//    {
//
//
//    //    try {
//            return loanTransactionService.checkLoanStatus(CustomerID);
//
//
////        }
////        catch(EntityNotFoundException ex){
////            return null;// ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
////        }
////        catch(Exception e)
////        {
////            return null;// ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
////
////        }
//
//
//    }

    @GetMapping("/status/{CustomerID}")
    public LoanStatusResponsedto getLoanStatus(@PathVariable Long CustomerID) {
        String status = loanTransactionService.checkLoanStatus(CustomerID);
        return new LoanStatusResponsedto(CustomerID, status);
    }


///====================================================================================================================
                              ///ADMIN CONTROLLER ///





}
