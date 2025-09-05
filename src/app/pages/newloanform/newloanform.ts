import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-newloanform',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './newloanform.html',
  styleUrl: './newloanform.css'
})
export class Newloanform {
  loanApplication = {
    customerID: 0,
    loanamount: 0,
    applicationdate: new Date().toISOString().split('T')[0], 
    status: 'PENDING', 
    remarks: '',
    filelink: ''
  };

  statuses = ['PENDING', 'APPROVED', 'REJECTED']; 
  isSubmitting = false;
  errorMessage = '';

  constructor(private http: HttpClient, private router: Router) {}

  onSubmit() {
   
    if (!this.validateForm()) {
      return;
    }

    this.isSubmitting = true;
    this.errorMessage = '';

    
    const formData = {
      ...this.loanApplication,
      customerID: Number(this.loanApplication.customerID),
      loanamount: Number(this.loanApplication.loanamount)
    };

    this.http.post('http://localhost:8765/LOANTRANSACTION-SERVICE/api/v1/loans/apply', formData)
      .subscribe({
        next: (response) => {
          console.log('Loan application submitted successfully:', response);
          alert('Loan application submitted successfully!');
          // this.resetForm();
          this.router.navigate(['/home']); 
        },
        error: (err) => {
          console.error('Error submitting loan application', err);
          this.errorMessage = err.error?.message || 'Failed to submit loan application. Please try again.';
          alert(this.errorMessage);
        },
        complete: () => {
          this.isSubmitting = false;
        }
      });
  }

  private validateForm(): boolean {
    if (!this.loanApplication.customerID || this.loanApplication.customerID <= 0) {
      this.errorMessage = 'Please enter a valid Customer ID';
      alert(this.errorMessage);
      return false;
    }

    if (!this.loanApplication.loanamount || this.loanApplication.loanamount <= 0) {
      this.errorMessage = 'Please enter a valid loan amount';
      alert(this.errorMessage);
      return false;
    }

    if (!this.loanApplication.applicationdate) {
      this.errorMessage = 'Please select an application date';
      alert(this.errorMessage);
      return false;
    }

    return true;
  }

  // private resetForm(): void {
  //   this.loanApplication = {
  //     customerID: 0,
  //     loanamount: 0,
  //     applicationdate: new Date().toISOString().split('T')[0],
  //     status: 'PENDING',
  //     remarks: '',
  //     filelink: ''
  //   };
  //   this.errorMessage = '';
  // }

}
