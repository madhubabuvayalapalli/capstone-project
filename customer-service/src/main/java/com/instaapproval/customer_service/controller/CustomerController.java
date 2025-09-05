package com.instaapproval.customer_service.controller;

import com.instaapproval.customer_service.dto.CustomerDto;
import com.instaapproval.customer_service.entity.Customer;
import com.instaapproval.customer_service.service.CustomerService;
import com.instaapproval.customer_service.service.CustomerServiceImpl;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customers")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
private CustomerService service;

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping("/login")
    public String login(@RequestBody CustomerDto customerDto)
    {
        System.out.println(customerDto);
        return service.verify(customerDto);
    }
    @PostMapping("/register")
    public ResponseEntity<?> save(@RequestBody CustomerDto customerDto)
    {
        Customer d= customerService.postCustomer(customerDto);
        if(d!=null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{CustomerID}")
    public ResponseEntity<?> update(@PathVariable Long CustomerID,  @RequestBody CustomerDto customerDto) {
        try {
            Customer d = customerService.updatebyId(CustomerID,customerDto);
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


        return  ResponseEntity.ok(customerService.getAll());


    }








    @GetMapping("/{CustomerID}")
    public ResponseEntity<?> getbyid(@PathVariable Long CustomerID)
    {

        try {
            return ResponseEntity.ok(customerService.getbyId(CustomerID));
        }
        catch(EntityNotFoundException ex){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
        catch(Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");

        }

    }


    @DeleteMapping("/{CustomerID}")
    public   ResponseEntity<?> delete(@PathVariable Long CustomerID)
    {


        try {
            customerService.delete(CustomerID);
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
//    public   ResponseEntity<?> getLoanStatus(@PathVariable Long CustomerID)
//    {
//
//
//        try {
//            return ResponseEntity.ok(customerService.checkLoanStatus(CustomerID));
//
//
//        }
//        catch(EntityNotFoundException ex){
//            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
//        }
//        catch(Exception e)
//        {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong");
//
//        }
//
//
//    }



}
