package com.instaapproval.customer_service.service;

import com.instaapproval.customer_service.dto.CustomerDto;
import com.instaapproval.customer_service.entity.Customer;

import java.util.List;

public interface CustomerService {

    public Customer postCustomer(CustomerDto customerDto);

    public List<Customer> getAll();

    public Customer updatebyId(Long  CustomerID, CustomerDto customerDto);

    public Customer getbyId(Long CustomerID);

    public void delete(Long CustomerID);
    public String verify(CustomerDto  customerDto);
}
