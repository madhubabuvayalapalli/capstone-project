import { HttpClient } from '@angular/common/http';
import { Component, NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
   email: string = '';
  password: string = '';
  errorMessage: string = '';

  constructor(private http: HttpClient, private router: Router) {}

  onLogin() {
    const loginData = { email: this.email, password: this.password };

    this.http.post('http:8761//localhost:/customers/login', loginData, { responseType: 'text' })
      .subscribe({
        next: (response: any) => {
          console.log('Login successful', response);
         
          localStorage.setItem('customer', JSON.stringify(response));
          this.router.navigate(['/dashboard']); 
        },
        error: (err) => {
          console.error('Login failed', err);
          this.errorMessage = 'Invalid email or password';
        }
      });

}
}
