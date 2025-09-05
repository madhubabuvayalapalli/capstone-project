import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-loanapplicationlist',
   standalone: true,
  imports: [FormsModule, HttpClientModule, CommonModule],
  templateUrl: './loanapplicationlist.html',
  styleUrl: './loanapplicationlist.css'
})
export class Loanapplicationlist  implements OnInit{
    loanApplications: any[] = [];
  loading: boolean = true;
  errorMessage: string = '';

  constructor(private http: HttpClient, private cdr: ChangeDetectorRef) {}

  ngOnInit(): void {
    console.log('Component initialized, loading:', this.loading);
    this.http.get<any[]>('http://localhost:8765/LOANTRANSACTION-SERVICE/api/v1/loans/all')
      .subscribe(
        (data) => {
          console.log('Raw response data:', data);
          console.log('Data type:', typeof data);
          console.log('Is array:', Array.isArray(data));
          console.log('Data length:', data ? data.length : 'null/undefined');
          
          this.loanApplications = data || [];
          this.loading = false;
          
          console.log('Updated loanApplications:', this.loanApplications);
          console.log('Updated loading state:', this.loading);
          console.log('loanApplications length:', this.loanApplications.length);
          
          
          this.cdr.detectChanges();
        },
        (err) => {
          console.error('Error fetching loan applications', err);
          this.errorMessage = 'Failed to load loan applications!';
          this.loading = false;
          console.log('Error - Updated loading state:', this.loading);
          
          
          this.cdr.detectChanges();
        }
      );
  }

}
