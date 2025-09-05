package com.instaapproval.customer_service.service;

import com.instaapproval.customer_service.dto.CustomerDto;
import com.instaapproval.customer_service.entity.Customer;
import com.instaapproval.customer_service.repository.CustomerRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authmanager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
     @Autowired
    private  CustomerRepo customerRepo;


    public String verify(CustomerDto  customerDto) {

        Authentication authentication =
                authmanager.authenticate(new UsernamePasswordAuthenticationToken(customerDto.getEmail(),customerDto.getPassword()));

        if(authentication.isAuthenticated())
            return jwtService.generateToken(customerDto.getEmail());

        return "fail";
    }

  ;


    public Customer postCustomer(CustomerDto customerDto)
    {

        return customer_save(new Customer(),customerDto);
    }


    public Customer customer_save(Customer customerEntity, CustomerDto customerDto)
    {
      //  customerEntity.setCustomerID(customerDto.getCustomerID());
        customerEntity.setCib(customerDto.getCib());
        customerEntity.setName(customerDto.getName());
        customerEntity.setEmail(customerDto.getEmail());
        customerEntity.setPhone(customerDto.getPhone());
        customerEntity.setAddress(customerDto.getAddress());
        customerEntity.setDateofBirth(customerDto.getDateofBirth());
        customerEntity.setRegistrationDate(customerDto.getRegistrationDate());
        customerEntity.setPassword(encoder.encode(customerDto.getPassword()));
       return   customerRepo.save(customerEntity);
    }

    public List<Customer> getAll()
    {


        return customerRepo.findAll();
    }

    public Customer updatebyId(Long  CustomerID, CustomerDto customerDto)
    {

        Optional<Customer> customer=  customerRepo.findById(CustomerID);
        if(customer.isPresent())
        {
            return   customer_save(customer.get(),customerDto);
        }
        else {
            throw new EntityNotFoundException(" customer is not found with customer_id"+ CustomerID);
        }
    }

    public Customer getbyId(Long CustomerID) {
        Optional<Customer> dr=  customerRepo.findById(CustomerID);

        if(dr.isPresent()){
            return dr.get();
        }else {
            throw new EntityNotFoundException("customerr with the id is not found "+CustomerID );
        }
    }

    public void delete(Long CustomerID) {
        Optional<Customer> dr = customerRepo.findById(CustomerID);

        if (dr.isPresent()) {
            customerRepo.deleteById(CustomerID);
        } else {
            throw new EntityNotFoundException("Customer with the id is not found " + CustomerID);
        }
    }

//    public String checkLoanStatus(Long CustomerID){
//
//        Optional<Customer> dr = customerRepo.findById(CustomerID);
//
//        if (dr.isPresent()) {
//
//
//            String status= customerRepo.findStatusByCustomerId(CustomerID);
//            return status;
//        } else {
//            throw new EntityNotFoundException("Customer with the id is not found " + CustomerID);
//        }
//
//    }


//    GET /api/v1/loans/status/{loanId} – Check loan status.
//            PUT /api/v1/loans/update/{loanId} – Update loan details (before approval).
//    DELETE /api/v1/loans/cancel/{loanId} – Cancel loan request.



}
