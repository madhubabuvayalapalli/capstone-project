import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-registerc',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './registerc.html',
  styleUrl: './registerc.css'
})
export class Registerc {
  customer = {
    name: '',
    email: '',
    phone: '',
    password: '',
    address: '',
    dateofBirth: '',
    cib: 0,
    registrationDate: new Date().toISOString().split('T')[0] 
  };

  isSubmitting = false;
  errorMessage = '';

  constructor(private http: HttpClient, private router: Router) {
  
  }



  onRegister() {

    this.http.post('http://localhost:8761/CUSTOMER-SERVICE/api/v1/customers/register', registrationData)
      .subscribe({
        next: (response) => {
          console.log('Registration successful:', response);
          alert('Registration successful! Please login.');
          this.resetForm();
          this.router.navigate(['/login']);
        },
        error: (err) => {
          console.error('Registration failed', err);
          console.error('Error status:', err.status);
          console.error('Error message:', err.message);
          console.error('Error details:', err.error);
          
          
          if (err.status === 0) {
            alert('Cannot connect to server. Please check if backend is running on http://localhost:8761');
          } else if (err.status === 404) {
            alert('Registration endpoint not found. Please check the API URL.');
          } else if (err.status === 400) {
            alert('Invalid data. Please check your inputs.');
          } else {
            alert(`Registration failed: ${err.status} - ${err.message || 'Unknown error'}`);
          }
          
          this.isSubmitting = false;
        },
        complete: () => {
          this.isSubmitting = false;
        }
      });
  }

  

  private isValidEmail(email: string): boolean {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  }



  private resetForm(): void {
    this.customer = {
      name: '',
      email: '',
      phone: '',
      password: '',
      address: '',
      dateofBirth: '',
      cib: 0,
      registrationDate: new Date().toISOString().split('T')[0]
    };
    this.errorMessage = '';
  }

}
