package com.instaapproval.loanTransaction_service.service;

import com.instaapproval.loanTransaction_service.entity.Admin;
import com.instaapproval.loanTransaction_service.repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;
    public Admin postAdminDetails(Admin admin)
    {
      return   adminRepo.save(admin);

    }

    public Admin updateAdminDetails(Admin admin)
    {
        return   adminRepo.save(admin);

    }
}
