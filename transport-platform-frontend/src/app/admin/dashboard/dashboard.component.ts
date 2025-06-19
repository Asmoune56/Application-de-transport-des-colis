import { Component, OnInit } from '@angular/core';
import { DashboardService, DashboardStatsDTO } from '../../services/dashboard.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  stats: DashboardStatsDTO = {
    usersCount: 0,
    tripsCount: 0,
    parcelsCount: 0,
    requestsCount: 0
  };

  loading = true;
  error = '';

  constructor(private dashboardService: DashboardService) {}

  ngOnInit(): void {
    this.dashboardService.getStats().subscribe({
      next: (data) => {
        console.log('📊 Received stats:', data); // ✅ للتأكد من استقبال البيانات
        this.stats = data;
        this.loading = false;
      },
      error: (err) => {
        console.error('❌ Dashboard Error:', err); // ✅ في حال وجود خطأ
        this.error = 'Error loading dashboard stats';
        this.loading = false;
      }
    });
  }

}
