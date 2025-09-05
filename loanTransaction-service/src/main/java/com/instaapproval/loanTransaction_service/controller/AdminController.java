package com.instaapproval.loanTransaction_service.controller;

import com.instaapproval.loanTransaction_service.entity.Admin;
import com.instaapproval.loanTransaction_service.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<?> saveAdmin(@RequestBody Admin admin)
    {
        Admin d= adminService.postAdminDetails(admin);
        if(d!=null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAdmin(@RequestBody Admin admin)
    {
        Admin d= adminService.updateAdminDetails(admin);
        if(d!=null) {
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
