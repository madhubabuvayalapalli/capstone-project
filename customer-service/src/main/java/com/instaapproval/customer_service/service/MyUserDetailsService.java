package com.instaapproval.customer_service.service;

import com.instaapproval.customer_service.entity.Customer;
import com.instaapproval.customer_service.entity.UserPrincipal;
import com.instaapproval.customer_service.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Customer customer = customerRepo.findByEmail(username);
        if(customer == null){
            System.out.println("customer not found ");
            throw new UsernameNotFoundException("user not found");
        }

        return new UserPrincipal(customer);

    }
}
