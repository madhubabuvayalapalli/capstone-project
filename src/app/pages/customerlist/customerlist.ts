import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-customerlist',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './customerlist.html',
  styleUrl: './customerlist.css'
})
export class Customerlist implements OnInit {
  customers: any[] = [];
  loading: boolean = true;
  errorMessage: string = '';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.getCustomers();
  }

  getCustomers() {
    this.http.get("http://localhost:8765/CUSTOMER-SERVICE/api/v1/customers/all").subscribe({
      next: (result: any) => {
        this.customers = result;
        this.loading = false;
      },
      error: (err) => {
        console.error('Error fetching customers', err);
        this.errorMessage = 'Failed to load customers!';
        this.loading = false;
      }
    });
  }
}
